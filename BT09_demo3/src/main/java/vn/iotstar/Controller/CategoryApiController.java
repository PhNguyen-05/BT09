//package vn.iotstar.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import jakarta.validation.Valid;
//import vn.iotstar.Entity.CategoryEntity;
//import vn.iotstar.Service.CategoryService;
//
//@RestController
//@RequestMapping("api")
//public class CategoryApiController {
//
//    @Autowired
//    CategoryService CategoryService;
//
//    public CategoryApiController(CategoryService CategoryService) {
//        this.CategoryService = CategoryService;
//    }
//
//    @RequestMapping(value = "/category", method = RequestMethod.GET)
//    public ResponseEntity<List<CategoryEntity>> listAll() {
//        List<CategoryEntity> list = CategoryService.listAll();
//        if (list.isEmpty()) {
//            return new ResponseEntity<List<CategoryEntity>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<CategoryEntity>>(list, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
//    public CategoryEntity find(@PathVariable("id") Long id) {
//        CategoryEntity pro = CategoryService.get(id);
//        if (pro == null) {
//            ResponseEntity.notFound().build();
//        }
//        return pro;
//    }
//
//    @RequestMapping(value = "/category", method = RequestMethod.POST)
//    public CategoryEntity save(@Valid @RequestBody CategoryEntity category) {
//        return CategoryService.save(category);
//    }
//
//    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<CategoryEntity> update(@PathVariable(value = "id") Long id,
//                                                 @Valid @RequestBody CategoryEntity proForm) {
//        CategoryEntity category = CategoryService.get(id);
//        if (category == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        CategoryEntity updated = CategoryService.save(proForm);
//        return ResponseEntity.ok(updated);
//    }
//}


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
import vn.iotstar.Entity.CategoryEntity;
import vn.iotstar.Service.CategoryService;

@RestController
@RequestMapping("api")
public class CategoryApiController {

    @Autowired
    CategoryService categoryService;  // Lowercased variable name for convention

    public CategoryApiController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryEntity>> listAll() {
        List<CategoryEntity> list = categoryService.listAll();
        if (list.isEmpty()) {
            return new ResponseEntity<List<CategoryEntity>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CategoryEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoryEntity> find(@PathVariable("id") Long id) {
        CategoryEntity pro = categoryService.get(id);
        if (pro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pro);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public CategoryEntity save(@Valid @RequestBody CategoryEntity category) {
        return categoryService.save(category);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CategoryEntity> update(@PathVariable(value = "id") Long id,
                                                 @Valid @RequestBody CategoryEntity proForm) {
        CategoryEntity category = categoryService.get(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }

        CategoryEntity updated = categoryService.save(proForm);
        return ResponseEntity.ok(updated);
    }
}