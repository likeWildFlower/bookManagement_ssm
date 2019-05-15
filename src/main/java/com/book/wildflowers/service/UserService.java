package com.book.wildflowers.service;

import com.book.wildflowers.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryUser();
//    用户登录
boolean loginUser(String userName,String userPassword);
    User queryUserByname(String userName);
}
