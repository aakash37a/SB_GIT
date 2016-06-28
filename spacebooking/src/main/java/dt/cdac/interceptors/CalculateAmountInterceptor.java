package dt.cdac.interceptors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import dt.cdac.model.PropertyBooking;

public class CalculateAmountInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet
	 * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 * 
	 * 
	 * to calculate the total amount as user has selected no of days in form
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("FROM Interceptor-------------" + modelAndView);
		Map<String, Object> model = modelAndView.getModel();
		String view = modelAndView.getViewName();
		// Restricting this code to not to run if there are binding errors...
		if (!view.equals("propertyBooking")) {
			// Getting bean from model
			PropertyBooking propertyBooking = (PropertyBooking) model
					.get("propertyBooking");
			String startDate = propertyBooking.getStartDate();
			String endDate = propertyBooking.getEndDate();

			DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date startdate = sdf.parse(startDate);
			Date enddate = sdf.parse(endDate);
			Calendar calendar1 = Calendar.getInstance();
			Calendar calendar2 = Calendar.getInstance();
			calendar1.setTime(startdate);
			calendar2.setTime(enddate);
			// Calculating no. of days of booking...
			long diffInDays = ((calendar2.getTimeInMillis() - calendar1
					.getTimeInMillis()) / (24 * 60 * 60 * 1000)) + 1;
			// System.out.println("FROM Interceptor-------------" + diffInDays);
			// System.out.println(model.get("daysRateMap"));
			Map<Integer, Double> map = (Map<Integer, Double>) model
					.get("daysRateMap");
			Double amount = map.get((int) (long) diffInDays);
			// Set Total Amount in PropertyBooking Bean
			((PropertyBooking) modelAndView.getModel().get("propertyBooking"))
					.setTotalAmt(amount);
			((PropertyBooking) modelAndView.getModel().get("propertyBooking"))
			.setDays((int) (long) diffInDays);
			

		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
