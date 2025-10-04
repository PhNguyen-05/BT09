package vn.iotstar.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import vn.iotstar.entity.UserInfo;
import vn.iotstar.repository.UserInfoRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return ResponseEntity.ok("User added successfully!");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Security with DB!";
    }
}