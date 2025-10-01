package vn.iotstar.controller;

import vn.iotstar.model.Customer;

import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    private final List<Customer> customers = List.of(
        Customer.builder().id("001").name("Nguyễn Hữu Trung").phoneNumber("0123456789").email("trunghspkt@gmail.com").build(),
        Customer.builder().id("002").name("Hữu Trung").phoneNumber("0987654321").email("huutrung@gmail.com").build()
    );

    // Trang chào khách (ai cũng vào được)
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("msg", "Xin chào! Đây là trang public.");
        return "hello"; // => hello.html
    }

    @GetMapping("/customers")
    public String customers(Model model, Authentication authentication) {
        if (authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            // ADMIN thấy tất cả khách hàng
            model.addAttribute("customers", customers);
        } else {
            // USER chỉ thấy khách hàng id=001
            model.addAttribute("customers",
                    customers.stream()
                            .filter(c -> c.getId().equals("001"))
                            .toList());
        }
        return "customers"; // customers.html
    }

    // Trang login
    @GetMapping("/login")
    public String login() {
        return "login"; // => login.html
    }
}
