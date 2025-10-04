//package vn.iotstar.Service;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import vn.iotstar.Entity.ProductEntity;
//import vn.iotstar.Repository.ProductRepository;
//
//@Service
//public class ProductService {
//
//    @Autowired
//    private ProductRepository repo;
//
//    public List<ProductEntity> listAll() {
//        return repo.findAll();
//    }
//
//    public ProductEntity save(ProductEntity product) {
//        return repo.save(product);
//    }
//
//    public ProductEntity get(Long id) {
//        return repo.findById(id).get();
//    }
//
//    public void delete(Long id) {
//        repo.deleteById(id);
//    }
//}


package vn.iotstar.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.ProductEntity;
import vn.iotstar.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<ProductEntity> listAll() {
        return repo.findAll();
    }

    public ProductEntity save(ProductEntity product) {
        return repo.save(product);
    }

    public ProductEntity get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}