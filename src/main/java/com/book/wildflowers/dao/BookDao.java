package com.book.wildflowers.dao;

import com.book.wildflowers.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {

    /**
     * 添加图书
     */
    public void addBook(Book book);
    public List<Book> queryAllBook();

    /**
     * 修改图书信息
     */
    public int updateBook(Book book);

    /**
     * 查询是否有重复的图书
     */
    Book queryBook(@Param("bookName") String bookName, @Param("type") String type, @Param("press") String press, @Param("author") String author);

    /**
     * 增加藏书的数量
     */
    public int addNumber(@Param("bookId") long bookId, @Param("number") int number);

    /**
     * 减少藏书的数量
     */
    public int reduceNumber(long bookId);

    /**
     * 通过id查阅图书
     */

    List<Book> queryById(long bookId);
    /**
     * 通过书名查阅图书
     */
    List<Book> queryByName(String bookName);
    /**
     * 通过type查阅图书
     */

    List<Book> queryByType(String type);

    /**
     * 通过press查阅图书
     */

    List<Book> queryByPress(String press);

    /**
     * 通过author查阅图书
     */

    List<Book> queryByAuthor(String author);


}
