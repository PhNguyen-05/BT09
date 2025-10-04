package vn.iotstar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}