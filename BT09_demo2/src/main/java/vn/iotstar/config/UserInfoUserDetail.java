package vn.iotstar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.iotstar.entity.UserInfo;
import vn.iotstar.repository.UserInfoRepository;
import vn.iotstar.service.UserService;

@Service
public class UserInfoUserDetail implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.getUserByUsername(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new UserService(userInfo);
    }
}