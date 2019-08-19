package com.na.service.impl;


import com.na.model.User;
import com.na.repository.UserRepository;
import com.na.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> finAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User post) {
    userRepository.save(post);
    }

    @Override
    public void remove(Long id) {
    userRepository.remove(id);
    }
}
