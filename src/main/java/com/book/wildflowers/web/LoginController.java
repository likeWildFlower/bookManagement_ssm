package com.book.wildflowers.web;

import com.book.wildflowers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

@ResponseBody
@RequestMapping("/login")
    public int login(String name, String password, String type,HttpSession session) {
    session.setAttribute("loginUser", name);
    if (userService.loginUser(name, password)) {
        return 0;
    } else {
        return 1;
    }
}
}
