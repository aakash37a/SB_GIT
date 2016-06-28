package dt.cdac.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import dt.cdac.dao.PropertyRateDaoImpl;
import dt.cdac.model.PropertyRate;

@Service
public class PropertyRateService {
	@Autowired
	private PropertyRateDaoImpl service;
	
	
	@Transactional
	public List<PropertyRate> getPropertyRateByPropertyId(String propertyId){
		System.out.println("in getPropertyRate()");
		return service.getPropertyRateByPropertyId(propertyId);
	}
	
	
	
}
