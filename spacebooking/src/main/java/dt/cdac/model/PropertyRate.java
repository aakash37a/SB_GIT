package dt.cdac.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the property_rates database table.
 * 
 */
@Entity
@Table(name="property_rates")
@NamedQueries({
	@NamedQuery(name="PropertyRate.findAll", query="SELECT p FROM PropertyRate p"),
	@NamedQuery(name = "PropertyRate.findPropertyRateByPropertyId", query = "FROM PropertyRate where propertyId=?") })
public class PropertyRate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="fifthday_rate")
	private double fifthdayRate;

	@Column(name="fixed_days")
	private int fixedDays;

	@Column(name="fourday_rate")
	private double fourdayRate;

	@Column(name="max_days")
	private int maxDays;

	@Column(name="min_days")
	private int minDays;

	@Column(name="oneday_rate")
	private double onedayRate;

	private String propertyId;

	@Column(name="security1_rate")
	private double security1Rate;

	@Column(name="security2_rate")
	private double security2Rate;

	@Column(name="subsequentday_rate")
	private double subsequentdayRate;

	@Column(name="threeday_rate")
	private double threedayRate;

	@Column(name="twoday_rate")
	private double twodayRate;

	public PropertyRate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getFifthdayRate() {
		return this.fifthdayRate;
	}

	public void setFifthdayRate(double fifthdayRate) {
		this.fifthdayRate = fifthdayRate;
	}

	public int getFixedDays() {
		return this.fixedDays;
	}

	public void setFixedDays(int fixedDays) {
		this.fixedDays = fixedDays;
	}

	public double getFourdayRate() {
		return this.fourdayRate;
	}

	public void setFourdayRate(double fourdayRate) {
		this.fourdayRate = fourdayRate;
	}

	public int getMaxDays() {
		return this.maxDays;
	}

	public void setMaxDays(int maxDays) {
		this.maxDays = maxDays;
	}

	public int getMinDays() {
		return this.minDays;
	}

	public void setMinDays(int minDays) {
		this.minDays = minDays;
	}

	public double getOnedayRate() {
		return this.onedayRate;
	}

	public void setOnedayRate(double onedayRate) {
		this.onedayRate = onedayRate;
	}

	public String getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public double getSecurity1Rate() {
		return this.security1Rate;
	}

	public void setSecurity1Rate(double security1Rate) {
		this.security1Rate = security1Rate;
	}

	public double getSecurity2Rate() {
		return this.security2Rate;
	}

	public void setSecurity2Rate(double security2Rate) {
		this.security2Rate = security2Rate;
	}

	public double getSubsequentdayRate() {
		return this.subsequentdayRate;
	}

	public void setSubsequentdayRate(double subsequentdayRate) {
		this.subsequentdayRate = subsequentdayRate;
	}

	public double getThreedayRate() {
		return this.threedayRate;
	}

	public void setThreedayRate(double threedayRate) {
		this.threedayRate = threedayRate;
	}

	public double getTwodayRate() {
		return this.twodayRate;
	}

	public void setTwodayRate(double twodayRate) {
		this.twodayRate = twodayRate;
	}

}