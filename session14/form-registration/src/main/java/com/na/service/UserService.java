package com.na.service;

import com.na.model.User;

import java.util.List;

public interface UserService {
//    Page<User> findAll(Pageable pageable);

    List<User> finAll();

    User findById(Long id);

    void save(User user);

    void remove(Long id);

}
