package com.dao;

import com.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public User getUserById(long id);
    public User getUserByUsername(String username);
    public User getUserByNamePass(User user);
}
