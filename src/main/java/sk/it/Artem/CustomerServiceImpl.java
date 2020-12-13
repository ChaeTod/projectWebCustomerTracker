package sk.it.Artem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.it.Artem.dao.CustomerDAO;
import sk.it.Artem.entity.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImlp implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;  // inject Customer DAO

    @Override
    @Transactional // define transactions at Service layer
    public List<Customer> getCustomer() {
        return customerDAO.getCustomers();  // delegate calls to DAO
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }
}
