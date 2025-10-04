//package vn.iotstar.repository;
//
//public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
//	Optional<UserInfo> findByName(String username)
//}

package vn.iotstar.repository;

import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.iotstar.entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    @Query("SELECT u FROM UserInfo u WHERE u.username = :username")
    UserInfo getUserByUsername(@Param("username") String username);

    Optional<UserInfo> findByUsername(String username);
}