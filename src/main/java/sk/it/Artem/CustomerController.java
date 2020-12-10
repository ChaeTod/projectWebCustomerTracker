package sk.it.Artem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.it.Artem.dao.CustomerDAO;
import sk.it.Artem.entity.Customer;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // inject the CustomerDAO
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model model){

        // get customers from the dao
        List<Customer> customerList = customerDAO.getCustomers();

        model.addAttribute("customers", customerList); // first - name, second - value

        return "list-customer";
    }

}