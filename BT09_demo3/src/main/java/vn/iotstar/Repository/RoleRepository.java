//package vn.iotstar.Repository;
//
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import vn.iotstar.Entity.RoleEntity;   
//
//@Repository
//public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
//    
//    @Query("SELECT r FROM RoleEntity r WHERE r.name = :name")
//    RoleEntity getRoleByName(@Param("name") String name);
//
//    Optional<RoleEntity> findByName(String name);
//}
package vn.iotstar.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(String name);
}