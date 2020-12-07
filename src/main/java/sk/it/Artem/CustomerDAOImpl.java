package sk.it.Artem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import sk.it.Artem.entity.Customer;

import javax.transaction.Transactional;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query<Customer> customerQuery = session.createQuery("from Customer", Customer.class);

        List<Customer> customers = customerQuery.getResultList();

        return customers;
    }
}

