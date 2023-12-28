package com.microservices.user.service;



import com.microservices.user.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long carId);
    User save(User user);
    User update(User user);
    void deleteById(Long userId);
}
