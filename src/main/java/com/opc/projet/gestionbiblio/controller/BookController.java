package com.opc.projet.gestionbiblio.controller;

import com.opc.projet.gestionbiblio.model.Book;
import com.opc.projet.gestionbiblio.service.contract.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping({"", "/", "/list"})
    public String getBooks(Model pModel){
        pModel.addAttribute("books", bookService.getAll());
        return "books/list";
    }

    @RequestMapping("/{id}")
    public String getBook(@PathVariable int id, Model pModel){
        Book vBook = bookService.getById(id);
        if(vBook == null){
            return "redirect:/books/list";
        }
        pModel.addAttribute("book", vBook);
        return "books/details";
    }

    @RequestMapping("/new")
    public String newBook(Model pModel){
        pModel.addAttribute("book", new Book());
        return "books/form";
    }

    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable int id, Model pModel){
        Book vBook = bookService.getById(id);
        if(vBook == null){
            return "redirect:/books/list";
        }
        pModel.addAttribute("book", vBook);

        return "books/form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.deleteById(id);
        return "redirect:/books/list";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String saveOrUpdateBook(@Valid @ModelAttribute("book") Book pBook,
                                      BindingResult bindingResult){

        System.out.println("\n\n\n" + pBook + "\n\n\n");
//        if(bindingResult.hasErrors()){
//            return "books/form";
//        }
        Book book = bookService.save(pBook);
        return "redirect:/books/"+ book.getId();
    }

}
