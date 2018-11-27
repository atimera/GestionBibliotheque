package com.opc.projet.gestionbiblio.webapp.controller;

import com.opc.projet.gestionbiblio.webapp.entity.Book;
import com.opc.projet.gestionbiblio.webapp.entity.BookCopy;
import com.opc.projet.gestionbiblio.webapp.service.contract.BookCopyService;
import com.opc.projet.gestionbiblio.webapp.service.contract.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookCopyService bookCopyService;


    


    @GetMapping("/showBookForm")
    public String showBookForm(Model theModel){

        Book theBook = new Book();
        theModel.addAttribute("book", theBook);

        return "book-form";
    }

    @GetMapping("/showBookFormAdd")
    public String showBookFormAdd(Model theModel){
        Book theBook = new Book();
        theModel.addAttribute("book", theBook);
        return "book-form";
    }

    @PostMapping("/saveBook")
    public String saveBook(@Valid @ModelAttribute("book") Book theBook, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "book-form";
        }else {
            bookService.save(theBook);
            return  "redirect:/book/list";
        }
    }

    @GetMapping("/list")
    public String list(Model theModel){

        List<Book> books = bookService.getAll();

        theModel.addAttribute("books", books);

        return "list-book";
    }

    @GetMapping("/showBookCopyForm")
    public String showBookCopyForm(Model theModel){

        List<Book> books = bookService.getAll();

        BookCopy theCopy = new BookCopy();

        theModel.addAttribute("books",books);

        theModel.addAttribute("copy", theCopy);

        return "bookcopy-form";
    }

    @PostMapping("/saveBookCopy")
    public String saveBookCopy(@Valid @ModelAttribute("copy") BookCopy theBookCopy, BindingResult bindingResult){


        bookCopyService.save(theBookCopy);

        return "redirect:/book/copies";

    }

    @GetMapping("/addBookCopyForm")
    public String addBookCopyForm(Model theModel){


        // get the param of the book
        // try to find it in the database
        // if the book exist
        // set the book fields in the form Id, titile

        // create a copy model
        // send for handle to /addCopy

        // TODO: 26/11/2018

        Book theBook = new Book();
        BookCopy theCopy = new BookCopy();
        theModel.addAttribute("book",theBook);
        theModel.addAttribute("copy", theCopy);

        return "add-bookcopy-form";
    }

    @PostMapping("/addCopy")
    public String addCopy(@Valid @ModelAttribute("copy") BookCopy theCopy, BindingResult bindingResult){

        bookCopyService.save(theCopy);
        return "redirect:/book/list";

    }

    @GetMapping("/copies")
    public String listCopies(Model theModel){

        List<BookCopy> copies =  bookCopyService.getAll();

        theModel.addAttribute("copies", copies);

        return "list-book-copies";
    }
}
