package com.poletaiev.security.service;

import com.poletaiev.security.entity.User;
import com.poletaiev.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }

    public boolean save(User user) {
        return userRepository.save(user) != null;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
