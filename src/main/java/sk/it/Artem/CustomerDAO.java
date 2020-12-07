package sk.it.Artem;

import org.springframework.stereotype.Repository;
import sk.it.Artem.entity.Customer;

import java.util.List;

@Repository
public interface CustomerDAO {
    public List<Customer> getCustomers();
}

