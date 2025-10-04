package vn.iotstar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.ProductEntity;
import vn.iotstar.Service.ProductService;

@Controller
public class LoginController {

    @Autowired
    private ProductService service;

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        System.out.println("Logging user login success...");
        return "index";
    }

    @PostMapping("/login_failure_handler")
    public String loginFailureHandler() {
        System.out.println("Login failure handler....");
        return "login";
    }

    // Trang chủ hiển thị danh sách sản phẩm
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<ProductEntity> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    // Form thêm mới sản phẩm
    @RequestMapping("/new")
    public String showNewProductForm(Model model, 
                                     @ModelAttribute("product") ProductEntity product) {
        model.addAttribute("product", product);
        return "new_product";
    }

    // Lưu sản phẩm mới
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") ProductEntity product) {
        service.save(product);
        return "redirect:/";
    }

    // Form chỉnh sửa sản phẩm
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_product");
        ProductEntity product = service.get(id);
        mav.addObject("product", product);
        return mav;
    }

    // Xóa sản phẩm
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
