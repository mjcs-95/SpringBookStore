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
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookService myBookService;
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
//        ModelAndView modelView = new ModelAndView();
//        modelView.setViewName("bookList");
//        modelView.addObject("book", bookList);
        return new ModelAndView("bookList", "book", bookList);
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBookList> myBookList = myBookService.getMyBooks();
        model.addAttribute("myBookInHtml", myBookList);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book book=bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
        myBookService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book book=bookService.getBookById(id);
        model.addAttribute("myBookInHtml", book);

        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id, Model model) {
        bookService.deleteBookById(id);
        return "redirect:/available_books";
    }


    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/available_books";
    }

}
