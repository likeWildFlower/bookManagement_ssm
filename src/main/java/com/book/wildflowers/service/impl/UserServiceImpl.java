package com.book.wildflowers.service.impl;

import com.book.wildflowers.dao.UserDao;
import com.book.wildflowers.entity.Appointment;
import com.book.wildflowers.entity.Book;
import com.book.wildflowers.entity.BookReturn;
import com.book.wildflowers.entity.User;
import com.book.wildflowers.service.AppointmentService;
import com.book.wildflowers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;
    @Autowired
    private AppointmentService appointment;


    @Override
    public boolean loginUser(String userName, String userPassword) {
        User user=userDao.queryUserByname(userName);
        if(user==null){
            return false;
        }else if(userPassword.equals(user.getUserPassword())){
            return true;
        }else
            return false;
    }
public boolean addUser(User u){
        User user=userDao.queryUserByname(u.getUserName());
        if (user==null){
            userDao.addUser(u);
            return true;
        }else {
            return false;
        }
}

    public List<BookReturn> getBookReturnList(String name) {
        List<Book> bList = appointment.queryByUserNameWithBook(name);
        List<Appointment> appointList = appointment.queryByUserName(name);
        List<BookReturn> brList = new ArrayList<BookReturn>();
        for (int i = 0; i < bList.size(); i++) {
            /*
             * 创建所要输出的数据
             */
            BookReturn br = new BookReturn();
            br.setId(bList.get(i).getBookId());
            br.setName(bList.get(i).getBookName());
            br.setAuthor(bList.get(i).getAuthor());
            br.setPress(bList.get(i).getPress());
            br.setType(bList.get(i).getType());
            br.setNumber(""+bList.get(i).getNumber());
            br.setState(appointList.get(i).getBookState());

            /*
             * 修改图书时间输出格式
             */
            Date date = appointList.get(i).getAppointTime();
            DateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            datef.format(date);
            br.setDate(datef.format(date));
            /*
             * 将获得的数据加入list
             */
            brList.add(br);
        }
        return brList;
    }

    public int updateUserDay(int day, String userName) {

        return userDao.updateUserDay(day, userName);
    }


    public User queryUserByname(String userName) {
        // TODO Auto-generated method stub
        return userDao.queryUserByname(userName);
    }

    @Override
    public int addUserOverdue(String userName) {
        return userDao.addUserOverdue(userName);
    }

    public List<User> queryUser() {
        // TODO Auto-generated method stub
        return userDao.queryUser();
    }
}
