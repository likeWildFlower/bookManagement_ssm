package com.book.wildflowers.service.impl;

import com.book.wildflowers.entity.Appointment;
import com.book.wildflowers.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentService appointmentService;
    @Override
    public List<Appointment> queryByUserName(String userName) {
        return  appointmentService.queryByUserName(userName);
    }

    @Override
    public Appointment queryByBookIdAndName(String bookId, String name) {
        return appointmentService.queryByBookIdAndName(Long.parseLong(bookId),name);
    }

    @Override
    public int insertAppointment(String bookId, String userName, String bookState) {
        return appointmentService.insertAppointment(Long.parseLong(bookId), userName, bookState);
    }
}
