package com.book.wildflowers.web;

import com.book.wildflowers.service.AdminService;
import com.book.wildflowers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/user")
    private String user(Model model, String name) {
        model.addAttribute("name", name);
        return "user";
    }

    private String admin(Model model,String name){
        model.addAttribute("name",name);
        return "admin";
    }


    /**
     * 登录功能
     * @param name
     * @param password
     * @param type
     * @param session
     * @return
     */
@ResponseBody
@RequestMapping("/login")
    public int login(String name, String password, String type,HttpSession session) {
    if (type.equals("user")) {
        session.setAttribute("loginUser", name);
        if (userService.loginUser(name, password)) {
            return 0;
        } else {
            return 1;
        }
    }
    else {
        session.setAttribute("loginAdmin", name);
        if (adminService.loginAdmin(name,password)){
            return 2;
        }else {
            return 3;
        }
    }
}
}
