package sk.it.Artem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.it.Artem.entity.Customer;
import sk.it.Artem.service.CustomerService;
import sun.text.normalizer.NormalizerBase;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    /*  not in use anymore
    // inject the CustomerDAO
    @Autowired
    private CustomerDAO customerDAO;
    */

    @Autowired
    private CustomerService customerService; // need to inject our customer service

    @GetMapping("/list")
    public String listCustomers(Model model){

        // get customers from the dao
        List<Customer> customerList = customerService.getCustomer();  // delegate call to Service

        model.addAttribute("customers", customerList); // first - name, second - value

        return "list-customer";
    }

    @GetMapping("/showFromForAdd")
    public String showFormForAdd(Model model){

        // create model attribute to bind form data
        Customer customer = new Customer();

        model.addAttribute("customer", customer); // first - name, second - value

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer (@ModelAttribute("customer") Customer customer) {

        // save the customer using service
        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model){

        // get the customer from our service
        Customer customer = customerService.getCustomer(id);

        // set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);

        // send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id, Model model){

        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }

}