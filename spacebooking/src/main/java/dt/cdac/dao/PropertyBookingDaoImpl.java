package dt.cdac.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





import dt.cdac.model.PropertyBooking;

@Repository
public class PropertyBookingDaoImpl {

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
	

	public void addPropertyBooking(PropertyBooking p) {
		Session session = getCurrentSession();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		p.setDatetime(dateFormat.format(date));
		session.persist(p);
		logger.info("Property saved successfully, Property Details="+p);
	}
}
