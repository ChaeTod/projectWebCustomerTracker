package sk.it.Artem;

import sk.it.Artem.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomer();

    public void saveCustomer (Customer customer);
}
