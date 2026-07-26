package com.fhg.familyhealthguardian.service;

import com.fhg.familyhealthguardian.entity.User;
import com.fhg.familyhealthguardian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(String email) {
        return userRepository.findByEmail(email);
    }
}
