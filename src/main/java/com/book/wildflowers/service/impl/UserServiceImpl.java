package com.book.wildflowers.service.impl;

import com.book.wildflowers.dao.UserDao;
import com.book.wildflowers.entity.User;
import com.book.wildflowers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;



    @Override
    public boolean loginUser(String userName, String userPassword) {
        User user=userDao.queryUserByname(userName);
        if(user==null){
            return false;
        }else if(userPassword.equals(user.getUserPassword())){
            return true;
        }else
            return false;
    }

    public List<User> queryUser() {
        // TODO Auto-generated method stub
        return userDao.queryUser();
    }
    public User queryUserByname(String userName) {
        // TODO Auto-generated method stub
        return userDao.queryUserByname(userName);
    }
}
