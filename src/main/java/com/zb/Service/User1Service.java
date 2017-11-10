package com.zb.Service;

import com.zb.model.User1;

import java.util.List;

public interface User1Service {
    void saveUser1(User1 user1);
    User1 getUser1(String name);
    void deleteUser1(int id);
    void updateUser1(User1 user1);
    User1 findById(int id);
    List<User1> findAll();
}
