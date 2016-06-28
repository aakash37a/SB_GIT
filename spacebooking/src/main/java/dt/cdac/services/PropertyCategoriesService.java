package dt.cdac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dt.cdac.dao.PropertyCategoryDaoImpl;
import dt.cdac.model.PropertyCategory;

@Service
public class PropertyCategoriesService {

	@Autowired
	private PropertyCategoryDaoImpl service;
	
	
	@Transactional
	public List<PropertyCategory> getPropertyCategories(){
		System.out.println("in getPropertyCategories()");
		return service.getPropertyCategories();
	}
}
