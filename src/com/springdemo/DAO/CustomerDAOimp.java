package com.springdemo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.entity.Customer;
@Repository 
public class CustomerDAOimp implements CustomerDAO {

	@Autowired
	// need to inject the session factory
	private SessionFactory sessionFactory;
	
	
	@Override

	public List<Customer> getCustomers() {
		
		
			// create current session 
			Session currentsession=sessionFactory.getCurrentSession();
			// create the query
			Query <Customer>  theQuery= 
					currentsession.createQuery("from Customer order by lastname",Customer.class);
			//  the and show result 
			List<Customer> customer=theQuery.getResultList();
			
			return customer;
		
	}


	@Override
	public void saveCustomer(Customer thecustomer) {
		// get hinbernate session
		Session currentsession=sessionFactory.getCurrentSession();
		currentsession.saveOrUpdate(thecustomer);
		
		
	}


	@Override
	public Customer getCustomer(int theId) {
		Session currentsession=sessionFactory.getCurrentSession();
		Customer thecustomer=currentsession.get(Customer.class, theId);
		return thecustomer;
		
	}





	@Override
	public void deleteCustomer(int theid) {
		   Session currentsession=sessionFactory.getCurrentSession();
	       Query  theQuery=currentsession.createQuery(" delete from Customer where id= :customerId");
	       theQuery.setParameter("customerId",theid ); 
	       theQuery.executeUpdate();
		
	}


}
