package dt.cdac.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dt.cdac.dao.PropertyBookingDaoImpl;
import dt.cdac.model.PropertyBooking;

@Service
public class PropertyBookingService {

	@Autowired
	private PropertyBookingDaoImpl dao;
	
	@Transactional
	public void addPropertyBooking(PropertyBooking p){
		dao.addPropertyBooking(p);
	}
}
