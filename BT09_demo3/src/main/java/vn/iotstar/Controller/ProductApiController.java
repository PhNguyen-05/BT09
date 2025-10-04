package vn.iotstar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import vn.iotstar.Entity.ProductEntity;
import vn.iotstar.Service.ProductService;

@RestController
@RequestMapping("api")
public class ProductApiController {

    @Autowired
    ProductService productService;

    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    // Lấy danh sách sản phẩm
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<List<ProductEntity>> listAll() {
        List<ProductEntity> list = productService.listAll();
        if (list.isEmpty()) {
            return new ResponseEntity<List<ProductEntity>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProductEntity>>(list, HttpStatus.OK);
    }

    // Tìm theo ID
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ProductEntity find(@PathVariable("id") Long id) {
        ProductEntity pro = productService.get(id);
        if (pro == null) {
            ResponseEntity.notFound().build();
        }
        return pro;
    }

    // Thêm mới sản phẩm
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ProductEntity save(@Valid @RequestBody ProductEntity category) {
        return productService.save(category);
    }

    // Cập nhật sản phẩm
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductEntity> update(@PathVariable(value = "id") Long id,
                                                @Valid @RequestBody ProductEntity proForm) {
        ProductEntity category = productService.get(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }

        ProductEntity updated = productService.save(proForm);
        return ResponseEntity.ok(updated);
    }

    // Xóa sản phẩm
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ProductEntity> delete(@PathVariable(value = "id") Long id) {
        ProductEntity pro = productService.get(id);
        if (pro == null) {
            return ResponseEntity.notFound().build();
        }

        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
