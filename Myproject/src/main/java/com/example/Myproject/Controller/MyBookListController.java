package com.example.Myproject.Controller;

import com.example.Myproject.Entity.Book;
import com.example.Myproject.Entity.MyBookList;
import com.example.Myproject.Service.BookService;
import com.example.Myproject.Service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyBookListController {

    @Autowired
    private MyBookService myBookService;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id")  int id) {
        myBookService.deleteById(id);
        return "redirect:/my_books";
    }


}
