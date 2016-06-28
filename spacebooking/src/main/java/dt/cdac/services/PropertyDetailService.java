package dt.cdac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dt.cdac.dao.PropertyDetailDaoImpl;
import dt.cdac.model.PropertyDetail;


@Service
public class PropertyDetailService {

	@Autowired
	private PropertyDetailDaoImpl service;
	
	
	@Transactional
	public List<PropertyDetail> getPropertyDetail(){
		System.out.println("in getPropertyDetail()");
		return service.getPropertyDetails();
	}
	
	@Transactional
	public List<PropertyDetail> getPropertyDetail(String location){
		System.out.println("in getPropertyDetail()");
		return service.getPropertyDetails(location);
	}
	
}
