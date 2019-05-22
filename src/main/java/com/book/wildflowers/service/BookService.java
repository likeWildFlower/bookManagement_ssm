package com.book.wildflowers.service;

import com.book.wildflowers.entity.Book;

import java.util.List;
/**
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 */
public interface BookService {



    void addBook(String name,String number,String type, String press,String author);

    List<Book> queryAllBook();

    int updateBook(Book book);

    Book queryBook(String bookName,String type,String press,String author);

    int addNumber(long bookId,String number);

    int reduceNumber(long bookId);

    /**
     * 查询一本图书
     *
     * @param bookId
     * @return
     */
    List<Book> getById(String bookId);

    List<Book> getByName(String name);

    List<Book> getByType(String type);

    List<Book> getByPress(String press);

    List<Book> getByAuthor(String author);
}
