package com.book.wildflowers.service.impl;

import com.book.wildflowers.dao.AppointmentDao;
import com.book.wildflowers.entity.Appointment;
import com.book.wildflowers.service.AppointmentService;
import com.book.wildflowers.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    protected AppointmentDao appointmentDao;

    public int insertAppointment(String bookId, String userName,String bookState) {
        // TODO Auto-generated method stub
        return appointmentDao.insertAppointment(Long.parseLong(bookId), userName, bookState);
    }


    public Appointment queryByBookIdAndName(String bookId,String name) {

        return appointmentDao.queryByBookIdAndName(Long.parseLong(bookId),name);
    }

    public List<Appointment> queryByUserName(String userName) {

        return appointmentDao.queryByUserName(userName);
    }

    public List<Book> queryByUserNameWithBook(String userName){

        return appointmentDao.queryByUserNameWithBook(userName);

    }


    public int reduceAppoint(String bookId,String name) {
        return appointmentDao.reduceAppoint(Long.parseLong(bookId),name);
    }
}
