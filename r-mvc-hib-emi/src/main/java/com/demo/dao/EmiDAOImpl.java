package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.entity.Customer;
import com.demo.entity.Emi;

@Repository
public class EmiDAOImpl implements EmiDAO {
// inject 
	@Autowired
	private SessionFactory sessionFactory;

	@Override

	public List<Emi> getEmis() {
		// create session
		Session currentSession = sessionFactory.getCurrentSession();
		// query
		Query<Emi> theQuery = currentSession.createQuery("from Emi ", Emi.class);
		// execute query
		List<Emi> emis = theQuery.getResultList();
		// return the results
		return emis;
	}

	@Override
	public void saveEmi(Emi theemi) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theemi);
	}
	
    @Override
	public Emi getEmi(int theno) {
	     // get the current  session
		   Session currentSession = sessionFactory.getCurrentSession();
    // now retrieve/read from database using the primary key
				Emi theEmi = currentSession.get(Emi.class, theno);

				return theEmi;

	}

}
