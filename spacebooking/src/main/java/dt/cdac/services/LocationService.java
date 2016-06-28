package dt.cdac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dt.cdac.dao.LocationDaoImpl;
import dt.cdac.model.Location;

@Service
public class LocationService {

	@Autowired
	private LocationDaoImpl service;
	
	
	@Transactional
	public List<Location> getLocation(){
		return service.getLocation();
	}
}
