package com.book.wildflowers.service;

import com.book.wildflowers.entity.Appointment;
import com.book.wildflowers.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentService {

    /**
     * 插入预约图书记录
     *
     * @param bookId
     * @param studentId
     * @return
     */
    int insertAppointment(String bookId, String userName, String bookState);

    /**
     * 通过图书编号和姓名查询预约图书记录
     *
     * @param bookId
     * @param name
     * @return
     */
    Appointment queryByBookIdAndName(String bookId,String name);

    /**
     * 通过用户名称查询预约图书纪录
     *
     * @param userName
     * @return
     */
    List<Appointment> queryByUserName(String userName);
    /**
     * 通过用户名称查询图书
     *
     * @param userName
     * @return
     */
    List<Book> queryByUserNameWithBook(String userName);

    int reduceAppoint(String bookId,String name);
}
