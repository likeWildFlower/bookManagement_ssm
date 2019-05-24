package com.book.wildflowers.service;

import com.book.wildflowers.entity.BookReturn;
import com.book.wildflowers.entity.User;

import java.util.List;

public interface UserService {
    boolean addUser(User u);
    List<User> queryUser();
    List<BookReturn> getBookReturnList(String name);
//    用户登录
    boolean loginUser(String userName,String userPassword);

    User queryUserByname(String userName);
//    添加用户
    int addUserOverdue(String userName);


    int updateUserDay(int day,String userName);
}
