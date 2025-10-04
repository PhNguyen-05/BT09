package vn.iotstar.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public String getCustomerList(Model model) {
        model.addAttribute("title", "Customer List");
        model.addAttribute("message", "Welcome to Customers Page - Only for USER role!");
        return "customers";  // Thymeleaf template: src/main/resources/templates/customers.html
    }
}