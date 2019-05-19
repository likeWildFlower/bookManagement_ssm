package com.book.wildflowers.service.impl;

import com.book.wildflowers.dao.AdminDao;
import com.book.wildflowers.entity.Admin;
import com.book.wildflowers.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public boolean loginAdmin(String adminName, String adminPassword) {
        Admin admin=adminDao.queryAdminByname(adminName);

        if (admin==null){
            return false;
        }else if (adminPassword.equals(admin.getAdminPassword())){
            return true;
        }else {
            return false;
        }
    }
}
