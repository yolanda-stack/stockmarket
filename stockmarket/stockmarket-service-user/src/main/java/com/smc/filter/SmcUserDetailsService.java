package com.smc.filter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.smc.entity.UserInfo;
import com.smc.service.UserService;

@Service
public class SmcUserDetailsService implements UserDetailsService {

  @Autowired
  UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	UserInfo users = userService.getUserByUsername(username);  
    if (users == null) {
      throw new UsernameNotFoundException("USERNAME NOT FOUND");
    }
    String password = users.getPassword();
    String role = users.getUsertype();
    Boolean userDisabled = false;
    if (!users.getConfirmed().equalsIgnoreCase("1")) {
      userDisabled = true;
    }
    return User.withUsername(username).password(new BCryptPasswordEncoder().encode(password)).disabled(userDisabled).roles(role).build();
  }

}
