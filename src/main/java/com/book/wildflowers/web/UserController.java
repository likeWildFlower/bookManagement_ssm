package com.book.wildflowers.web;

import com.book.wildflowers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.book.wildflowers.entity.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(HttpSession session, User user) {
        System.out.println(user.getUserName());
        boolean istrue = userService.loginUser(user.getUserName(), user.getUserPassword());
        if (istrue) {
            System.out.println("renming" + user.getUserName());

            return "success";

        } else
            return "error";
    }
}
