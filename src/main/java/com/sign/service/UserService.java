package com.sign.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.sign.entity.User;
import com.sign.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

}

