package sk.it.Artem.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.it.Artem.entity.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> query = session.createQuery("from Customer", Customer.class);

        // execute and get result
        List<Customer>  customers = query.getResultList();

        // return the result
        return customers;
    }
}
