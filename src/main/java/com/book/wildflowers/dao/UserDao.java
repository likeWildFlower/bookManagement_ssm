package com.book.wildflowers.dao;

import com.book.wildflowers.entity.User;

import java.util.List;

public interface UserDao {
     List<User> queryUser();
//    用户登录
     User queryUserByname(String userName);
//     新增用户
     void addUser(User user);
     int addUserOverdue(String userName);
}
