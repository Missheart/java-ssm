package com.service;

import com.entity.User;

public interface UserService {
    public User getUserById(long id);
    public User getUserByUsername(String username);
    public User getUserByNamePass(User user);
}
