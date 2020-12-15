package sk.it.Artem.dao;

import org.springframework.stereotype.Repository;
import sk.it.Artem.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);

    Customer getCustomers(int id);

    void deleteCustomer(int id);
}
