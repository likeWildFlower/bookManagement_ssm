package com.book.wildflowers.dao;

import com.book.wildflowers.entity.Admin;

public interface AdminDao {
   public Admin queryAdminByname(String adminName);
}
