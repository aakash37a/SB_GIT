package dt.cdac.model;

import java.io.Serializable;

import javax.persistence.*;



/**
 * The persistent class for the property_details database table.
 * 
 */

@NamedQuery(name="PropertyDetail.findAll", query="from PropertyDetail")
@Entity
@Table(name="property_details")
public class PropertyDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;


	@Column(name="accomodation_size")
	private int accomodationSize;

	@Column(name="category_id")
	private String categoryId;

	@Column(name="contact_email")
	private String contactEmail;

	@Column(name="contact_name")
	private String contactName;

	@Column(name="contact_no")
	private String contactNo;

	@Column(name="image_folder")
	private String imageFolder;

	private String location;

	

	@Column(name="property_area")
	private String propertyArea;

	@Column(name="property_desc")
	private String propertyDesc;

	@Column(name="property_id")
	private String propertyId;

	@Column(name="property_name")
	private String propertyName;



	public PropertyDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccomodationSize() {
		return this.accomodationSize;
	}

	public void setAccomodationSize(int accomodationSize) {
		this.accomodationSize = accomodationSize;
	}


	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getImageFolder() {
		return this.imageFolder;
	}

	public void setImageFolder(String imageFolder) {
		this.imageFolder = imageFolder;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}



	public String getPropertyArea() {
		return this.propertyArea;
	}

	public void setPropertyArea(String propertyArea) {
		this.propertyArea = propertyArea;
	}

	public String getPropertyDesc() {
		return this.propertyDesc;
	}

	public void setPropertyDesc(String propertyDesc) {
		this.propertyDesc = propertyDesc;
	}

	public String getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	@Override
	public String toString() {
		return "PropertyDetail [id=" + id + ", accomodationSize="
				+ accomodationSize + ", categoryId=" + categoryId
				+ ", contactEmail=" + contactEmail + ", contactName="
				+ contactName + ", contactNo=" + contactNo + ", imageFolder="
				+ imageFolder + ", location=" + location + ", propertyArea="
				+ propertyArea + ", propertyDesc=" + propertyDesc
				+ ", propertyId=" + propertyId + ", propertyName="
				+ propertyName + "]";
	}

	


	
	

}