package dt.cdac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dt.cdac.model.Location;


@Repository
public class LocationDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = LoggerFactory
			.getLogger(PropertyDetailDaoImpl.class);

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		System.out.println("in getCurrentSession() ");
		return sessionFactory.getCurrentSession();
	}
	
	public List<Location> getLocation(){
		org.hibernate.Query q = getCurrentSession().getNamedQuery(
				"Location.findAll");
		@SuppressWarnings("unchecked")
		List<Location> list = q.list();
		logger.info("Locations Fetched Successfully");
		return list;
	}
	
}







