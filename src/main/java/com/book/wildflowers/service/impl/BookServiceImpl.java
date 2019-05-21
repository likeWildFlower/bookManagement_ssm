package com.book.wildflowers.service.impl;

import com.book.wildflowers.dao.BookDao;
import com.book.wildflowers.entity.Book;
import com.book.wildflowers.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
