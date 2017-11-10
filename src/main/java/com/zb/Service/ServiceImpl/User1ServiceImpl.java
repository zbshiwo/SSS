package com.zb.Service.ServiceImpl;

import com.zb.Dao.User1Dao;
import com.zb.Service.User1Service;
import com.zb.model.User1;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component("user1Service")
public class User1ServiceImpl implements User1Service {
    private User1Dao user1Dao;

    public User1ServiceImpl() {

    }

    public void setUser1Dao(User1Dao user1Dao) {
        this.user1Dao = user1Dao;
    }

    @Override
    public void saveUser1(User1 user1) {
        if (user1Dao.findById(user1.getId()) == null){
            user1Dao.save(user1);
        }
    }

    @Override
    public User1 getUser1(String name) {
        if(name.trim().equals("") || name == null)
            return null;
        User1 user1 = user1Dao.getUser1(name);
        if(user1 == null){
            return null;
        }
        return user1;
    }

    @Override
    public void deleteUser1(int id) {
        if (user1Dao.findById(id) != null){
            user1Dao.delete(id);
        }
    }

    @Override
    public void updateUser1(User1 user1) {
        if (user1Dao.findById(user1.getId()) != null){
            user1Dao.update(user1);
        }
    }

    @Override
    public User1 findById(int id) {
        return user1Dao.findById(id);
    }

    @Override
    public List<User1> findAll() {
        return user1Dao.findAll();
    }
}
