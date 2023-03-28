package dao09;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import dto09.Customer;

public class Customerdao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	public List<Customer>check(String email){
		return manager.createQuery("select x from Customer x where email=?1").setParameter(1,email).getResultList();
	}
		public List<Customer>check(Long mob){
			return manager.createQuery("select x from Customer x where mob=?1").setParameter(1,mob).getResultList();
		}
	
		public void save (Customer user){
			transaction.begin();
			manager.persist(user);
			transaction.commit();
	
		}
		public Customer login(int cust_id){
			return manager.find(Customer.class,cust_id);
			
		}
		public void update(Customer customer) {
			transaction.begin();
			manager.merge(customer);
			transaction.commit();
			
		}
		}


	
