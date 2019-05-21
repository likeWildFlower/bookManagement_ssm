package com.book.wildflowers.service;

import com.book.wildflowers.entity.Book;

import java.util.List;

public interface BookService {



    void addBook(String name,String number,String type, String press,String author);

    List<Book> queryAllBook();

    int updateBook(Book book);

    Book queryBook(String bookName,String type,String press,String author);

    int addNumber(long bookId,String number);

    int reduceNumber(long bookId);
}
