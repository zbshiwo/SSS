package com.zb.Dao;

import com.zb.model.User1;

import java.util.List;

public interface User1Dao {
    void save(User1 user1);
    User1 getUser1(String name);
    void delete(int id);
    void update(User1 user1);
    User1 findById(int id);
    List<User1> findAll();
}
