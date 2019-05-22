package com.book.wildflowers.service.impl;

import com.book.wildflowers.dao.BookDao;
import com.book.wildflowers.entity.Book;
import com.book.wildflowers.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BookServiceImpl implements BookService {
@Autowired
    private BookDao bookDao;
    @Override
    public void addBook(String name, String number, String type, String press, String author) {
        Book book=new Book(name, Integer.valueOf(number).intValue(), type, press, author);
        bookDao.addBook(book);
    }

    @Override
    public List<Book> queryAllBook() {
        // TODO Auto-generated method stub
        return bookDao.queryAllBook();
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBook(String bookName, String type, String press, String author) {
        // TODO Auto-generated method stub
        return bookDao.queryBook(bookName, type, press, author);
    }

    @Override
    public int addNumber(long bookId, String number) {
        return bookDao.addNumber(bookId,Integer.valueOf(number));
    }

    @Override
    public int reduceNumber(long bookId) {
        return bookDao.reduceNumber(bookId);
    }

    @Override
    public List<Book> getById(String bookId) {
//        定义输入为0到9的数字
        Pattern pattern = Pattern.compile("[0-9]*");
        if(bookId==""){
            return  new ArrayList<Book>();
        }else{
            Matcher isNum = pattern.matcher(bookId);
            if(!isNum.matches()){
                return new ArrayList<Book>();
            }else{
                return bookDao.queryById(Long.parseLong(bookId));
            }
        }
    }

    @Override
    public List<Book> getByName(String name) {
        if(name==""){
            return  new ArrayList<Book>();
        }else{
            return bookDao.queryByName(name);
        }
    }

    @Override
    public List<Book> getByType(String type) {
        if(type==""){
            return  new ArrayList<Book>();
        }else{
            return bookDao.queryByType(type);
        }
    }

    @Override
    public List<Book> getByPress(String press) {
        if(press==""){
            return  new ArrayList<Book>();
        }else{
            return bookDao.queryByPress(press);
        }
    }

    @Override
    public List<Book> getByAuthor(String author) {
        if(author==""){
            return  new ArrayList<Book>();
        }else{
            return bookDao.queryByAuthor(author);
        }
    }
}
