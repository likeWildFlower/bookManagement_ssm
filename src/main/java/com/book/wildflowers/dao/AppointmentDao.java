package com.book.wildflowers.dao;

import com.book.wildflowers.entity.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentDao {

    /**
     * 插入图书记录
     * @param bookId
     * @param userName
     * @return
     */
    int insertAppointment(@Param("bookId") long bookId, @Param("userName") String userName, @Param("bookState") String bookState);

    /**
     * 通过图书编号和姓名查询预约图书记录
     * @param bookId
     * @param userName
     * @return
     */
    Appointment queryByBookIdAndName(@Param("bookId")long bookId, @Param("userName")String userName);
    /**
     * 通过用户名称查询预约图书纪录
     * @param userName
     * @return
     */
    List<Appointment> queryByUserName(String userName);
}
