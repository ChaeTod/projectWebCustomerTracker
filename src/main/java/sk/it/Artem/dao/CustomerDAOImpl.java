package sk.it.Artem.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.it.Artem.entity.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    // @Transactional  // remove this functionality up to a service level
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> customerQuery = session.createQuery("from Customer order by lastName", Customer.class);

        // execute and get result
        // List<Customer>  customers = query.getResultList();

        // return the result
        return customerQuery.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {

        // Session session = sessionFactory.getCurrentSession();
        // session.save(customer);

        // save/update the customer
        sessionFactory.getCurrentSession().saveOrUpdate(customer);

    }

    @Override
    public Customer getCustomers(int id) {

        // get the current hibernate session
        // Session session = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        // return session.get(Customer.class, id);

        return sessionFactory.getCurrentSession().get(Customer.class, id);

    }

    @Override
    public void deleteCustomer(int theId) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", theId);
        query.executeUpdate();
    }
}
