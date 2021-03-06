package dt.cdac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dt.cdac.model.PropertyRate;

@Repository
public class PropertyRateDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PropertyDetailDaoImpl.class);
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		System.out.println("in getCurrentSession() ");
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<PropertyRate> getPropertyRateByPropertyId(String propertyId){
		//List<PropertyDetail> p = getCurrentSession().createQuery("from PropertyDetail").list();
		org.hibernate.Query q = (org.hibernate.Query) getCurrentSession().getNamedQuery("PropertyRate.findPropertyRateByPropertyId");
		q.setParameter(0,propertyId);
		List<PropertyRate> p = q.list();
		logger.info("Property List Fetched Successfully");
		return p;
	}
}
