package dt.cdac.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The persistent class for the property_booking database table.
 * 
 */
@Entity
@Table(name = "property_booking")
@NamedQueries({
		@NamedQuery(name = "PropertyBooking.findAll", query = "FROM PropertyBooking "),
		@NamedQuery(name = "PropertyBooking.byID", query = "FROM PropertyBooking where id=?") })
public class PropertyBooking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@NotNull
	@Pattern(regexp = "^\\d{12}")
	@Column(name = "aadhaar_no")
	private String aadhaarNo;

	@NotEmpty
	@Length(max = 50)
	private String address;

	private String bookingID;

	@Column(name = "category_id")
	private String categoryId;

	private String datetime;

	@NotEmpty(message="Please provide valid email id...")
	@Email(message="Please provide valid email id...")
	private String emailID;

	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "end_date")
	private String endDate;

	@Pattern(regexp = "^\\d{10}")
	private String mobile;

	@NotNull
	private String name;

	@Column(name = "pan_no")
	private String panNo;

	private int pin;

	@Column(name = "property_id")
	private String propertyId;

	private int days;

	private String state;

	private String status;

	@Column(name = "subcategory_id")
	private String subcategoryId;

	@Column(name = "total_amt")
	private Double totalAmt;

	public PropertyBooking() {
	}

	public String getAadhaarNo() {
		return this.aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBookingID() {
		return this.bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getDatetime() {
		return this.datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getEmailID() {
		return this.emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPanNo() {
		return this.panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public int getPin() {
		return this.pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubcategoryId() {
		return this.subcategoryId;
	}

	public void setSubcategoryId(String subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public Double getTotalAmt() {
		return this.totalAmt;
	}

	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	@Override
	public String toString() {
		return "PropertyBooking [id=" + id + ", aadhaarNo=" + aadhaarNo
				+ ", address=" + address + ", bookingID=" + bookingID
				+ ", categoryId=" + categoryId + ", datetime=" + datetime
				+ ", emailID=" + emailID + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", mobile=" + mobile + ", name="
				+ name + ", panNo=" + panNo + ", pin=" + pin + ", propertyId="
				+ propertyId + ", days=" + days + ", state=" + state
				+ ", status=" + status + ", subcategoryId=" + subcategoryId
				+ ", totalAmt=" + totalAmt + "]";
	}

}