package com.book.wildflowers.web;

import com.book.wildflowers.entity.Book;
import com.book.wildflowers.service.AppointmentService;
import com.book.wildflowers.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AppointmentService appointmentService;



    /*
     * 判断查阅图书方式
     */
    @ResponseBody
    @RequestMapping("/queryBook")
    private List<Book> getBook(Model model, String key, Integer method) {
        System.out.println(key + method);
        List<Book> bList = new ArrayList<Book>();
        switch (method) {
            case 1:
                bList = bookService.getById(key);
                break;
            case 2:
                bList = bookService.getByName(key);
                break;
            case 3:
                bList = bookService.getByPress(key);
                break;
            case 4:
                bList = bookService.getByAuthor(key);
                break;
            case 5:
                bList = bookService.getByType(key);
                break;
            default:
                break;
        }
        if (bList.size() == 0) {
            System.out.println("meiy");
            model.addAttribute("bList", bList);
        } else {
            System.out.println(bList.size());
            model.addAttribute("bList", bList);
        }

        return bList;
    }

    /*
     * 租借图书
     */
    @ResponseBody
    @RequestMapping(value = "/getBook", produces = "text/plain;charset=UTF-8")
    private String getBook(String id,HttpSession session) {
        String aa=(String)session.getAttribute("loginUser");
        List<Book> bList = new ArrayList<Book>();
        bList = bookService.getById(id);
        System.out.println(id);
        System.out.println(bList.size());
        if (bList.get(0).getNumber() == 0) {
            return "fail";
        } else {
            if (null == appointmentService.queryByBookIdAndName(id, aa)) {
                bookService.reduceNumber(bList.get(0).getBookId());
                appointmentService.insertAppointment(id, aa, "借阅中");
                return "success";
            } else {
                return "more";
            }

        }
    }
}
