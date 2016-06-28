package dt.cdac.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the property_category database table.
 * 
 */
@Entity
@Table(name="property_category")
@NamedQuery(name="PropertyCategory.findAll", query="from PropertyCategory")
public class PropertyCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="category_id")
	private String categoryId;

	@Column(name="category_name")
	private String categoryName;

	@Column(name="subcategory_id")
	private String subcategoryId;

	public PropertyCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubcategoryId() {
		return this.subcategoryId;
	}

	public void setSubcategoryId(String subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	@Override
	public String toString() {
		return "PropertyCategory [id=" + id + ", categoryId=" + categoryId
				+ ", categoryName=" + categoryName + ", subcategoryId="
				+ subcategoryId + "]";
	}

}