package com.sign.service;

import com.sign.entity.User;
import com.sign.repository.UserRepository;
import com.sign.security.CustomUserDetails;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  private final UserRepository userRepo;

  public CustomUserDetailsService(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByUsername(username);
    if (user == null) {
        throw new UsernameNotFoundException("User not found: " + username);
    }
    return new CustomUserDetails(user);
  }
  
}
