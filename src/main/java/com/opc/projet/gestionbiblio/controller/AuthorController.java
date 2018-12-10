package com.opc.projet.gestionbiblio.controller;

import com.opc.projet.gestionbiblio.model.Author;
import com.opc.projet.gestionbiblio.service.contract.AuthorService;
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
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping({"", "/", "/list"})
    public String getAuthors(Model pModel){
        pModel.addAttribute("authors", authorService.getAll());
        return "authors/list";
    }

    @RequestMapping("/{id}")
    public String getAuthor(@PathVariable int id, Model pModel){
        Author vAuthor = authorService.getById(id);
        if(vAuthor == null){
            return "redirect:/authors/list";
        }
        pModel.addAttribute("author", vAuthor);
        return "authors/details";
    }

    @RequestMapping("/new")
    public String newAuthor(Model pModel){
        pModel.addAttribute("author", new Author());
        return "authors/form";
    }

    @RequestMapping("/edit/{id}")
    public String editAuthor(@PathVariable int id, Model pModel){
        Author vAuthor = authorService.getById(id);
        if(vAuthor == null){
            return "redirect:/authors/list";
        }
        pModel.addAttribute("author", vAuthor);

        return "authors/form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable int id){
        authorService.deleteById(id);
        return "redirect:/authors/list";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String saveOrUpdateAuthor(@Valid @ModelAttribute("author") Author pAuthor,
                                      BindingResult bindingResult){

        System.out.println("\n\n\n" + pAuthor + "\n\n\n");
//        if(bindingResult.hasErrors()){
//            return "authors/form";
//        }
        Author author = authorService.save(pAuthor);
        return "redirect:/authors/"+ author.getId();
    }

    @RequestMapping("/{id}/books")
    public String getAuthorBooks(@PathVariable() long id, Model pModel){

        Author author = authorService.getById(id);

        pModel.addAttribute("books", author.getBooks());

        return "authors/author-books";
    }

}
