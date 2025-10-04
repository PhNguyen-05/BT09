package vn.iotstar.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.CategoryEntity;
import vn.iotstar.Repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public List<CategoryEntity> listAll() {
        return repo.findAll();
    }

    public CategoryEntity save(CategoryEntity category) {
        return repo.save(category);
    }

    public CategoryEntity get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}