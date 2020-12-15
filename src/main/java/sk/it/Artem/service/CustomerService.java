package sk.it.Artem.service;

import sk.it.Artem.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomer();

    public void saveCustomer (Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
