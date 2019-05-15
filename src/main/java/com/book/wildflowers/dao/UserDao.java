package com.book.wildflowers.dao;

import com.book.wildflowers.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> queryUser();
//    用户登录
    public User queryUserByname(String userName);
}
