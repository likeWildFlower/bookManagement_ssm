package com.book.wildflowers.dao;

import com.book.wildflowers.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
     public List<User> queryUser();
//    用户登录
     public User queryUserByname(String userName);
//     新增用户
     public void addUser(User user);
     public int addUserOverdue(String userName);
//跟新用户可借阅天数
     public int updateUserDay(@Param("day")int day, @Param("userName")String userName);

}
