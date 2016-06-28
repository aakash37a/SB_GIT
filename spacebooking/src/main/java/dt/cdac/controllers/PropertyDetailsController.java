package dt.cdac.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import dt.cdac.model.PropertyBooking;
import dt.cdac.model.PropertyCategory;
import dt.cdac.model.PropertyDetail;
import dt.cdac.model.PropertyRate;
import dt.cdac.services.PropertyBookingService;
import dt.cdac.services.PropertyCategoriesService;
import dt.cdac.services.PropertyDetailService;
import dt.cdac.services.PropertyRateService;

@Controller
public class PropertyDetailsController {

	@Autowired
	private PropertyDetailService propertyDetailService;

	@Autowired
	private PropertyCategoriesService propertyCategoryService;

	@Autowired
	private PropertyBookingService propertyBookingService;

	@Autowired
	private PropertyRateService propertyRateService;

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@RequestMapping(value = "endPoints", method = RequestMethod.GET)
	public String getEndPointsInView(Model model) {
		model.addAttribute("endPoints", requestMappingHandlerMapping
				.getHandlerMethods().keySet());
		return "endPoints";
	}

	@RequestMapping("/listProperty")
	public String showAllPropertyDetails(Model model) {
		/*
		 * ModelAndView m = new ModelAndView("listproperties");
		 * m.addObject("details", propertyDetailService.getPropertyDetail());
		 */
		List<PropertyDetail> propertyList = propertyDetailService
				.getPropertyDetail();
		System.out.println(propertyList);

		model.addAttribute("propertyList", propertyList);
		return "listproperties";
	}

	@RequestMapping("/property/booking/{propertyid}")
	public String propertyBooking(@PathVariable String propertyid,
			@ModelAttribute("propertyBooking") PropertyBooking propertyBooking,
			Model model) {
		propertyBooking.setPropertyId(propertyid);
		model.addAttribute("daysList", getDaysListByPropertyId(propertyid));
		model.addAttribute("daysRateMap", getDayRateListByPropertyId(propertyid));
		return "propertyBooking";
	}

	@RequestMapping(value = "/property/booking/{propertyid}", method = RequestMethod.POST)
	public String propertyBook(
			@Valid @ModelAttribute PropertyBooking propertyBooking,
			BindingResult bindingResult,Model model,@PathVariable String propertyid) {
		model.addAttribute("daysList", getDaysListByPropertyId(propertyid));
		model.addAttribute("daysRateMap", getDayRateListByPropertyId(propertyid));
		if (bindingResult.hasErrors()) {
			return "propertyBooking";
		} else {
			//propertyBookingService.addPropertyBooking(propertyBooking);
			return "propertyBookingConfirm";
		}
	}

	public List<Integer> getDaysListByPropertyId(String propertyid) {
		List<PropertyRate> rates = propertyRateService
				.getPropertyRateByPropertyId(propertyid);
		int minDays = rates.get(0).getMinDays();
		int maxDays = rates.get(0).getMaxDays();
		List<Integer> daysList = new ArrayList<Integer>();
		for (int i = minDays; i <= maxDays; i++) {
			daysList.add(i);
		}
		return daysList;
	}

	public Map<Integer, Double> getDayRateListByPropertyId(String propertyid) {
		List<PropertyRate> rates = propertyRateService
				.getPropertyRateByPropertyId(propertyid);
		int minDays = rates.get(0).getMinDays();
		int maxDays = rates.get(0).getMaxDays();
		double[] dayRate = new double[] { rates.get(0).getOnedayRate(),
				rates.get(0).getTwodayRate(), rates.get(0).getThreedayRate(),
				rates.get(0).getFourdayRate(), rates.get(0).getFifthdayRate() };

		Map<Integer, Double> daysMap = new HashMap<Integer, Double>();
		for (int i = minDays; i <= maxDays; i++) {
			daysMap.put(i, dayRate[i - 1]);
		}
		return daysMap;
	}

	@ModelAttribute("propertyCategories")
	public List<PropertyCategory> getCategories() {
		List<PropertyCategory> selectList = propertyCategoryService
				.getPropertyCategories();
		System.out.println(selectList);
		return selectList;
	}

	@RequestMapping(value = "/property/booking/getAvailability")
	public @ResponseBody
	String check(@RequestParam String propertyId,
			@RequestParam String startDate, @RequestParam String endDate,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		// System.out.println("s----"+startDate+"----"+endDate);
		String responseText = "";
		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			java.util.Date startDate1 = sdf.parse(startDate);
			java.util.Date endDate1 = sdf.parse(endDate);
			// do further processing with Date object
			// Populate list of dates from check-in to check-out...
			List<Date> selectedDateList = new ArrayList<Date>();
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate1);
			while (cal.getTime().before(endDate1)) {
				// out.println(sdf.format(cal.getTime()));
				selectedDateList.add(cal.getTime());
				cal.add(Calendar.DATE, 1);
			}
			// out.println( sdf.format(cal.getTime())); // for the last date
			selectedDateList.add(cal.getTime()); // for the last date
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3307/space_booking?user=root&password=");
			String sql = "select * from availability where property_id='"
					+ propertyId + "'";
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			List<Date> bookedDateList = new ArrayList<Date>();
			while (rs.next()) {
				bookedDateList.add(rs.getDate(3));
				for (Date date : selectedDateList) {
					if (date.compareTo(rs.getDate(3)) == 0) {
						responseText += date + "already booked<br/>";
					}
				}
			}
			if (responseText.equals("")) {
				responseText += "Available for selected Dates";
			}
			rs.close();
			psmt.close();
			con.close();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return responseText;
	}
}
