package com.opc.projet.gestionbiblio.controller;

import com.opc.projet.gestionbiblio.model.Book;
import com.opc.projet.gestionbiblio.model.BookCopy;
import com.opc.projet.gestionbiblio.service.contract.BookCopyService;
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
@RequestMapping("/copies")
public class BookCopyController {

    @Autowired
    private BookCopyService bookCopyService;


    @RequestMapping({"", "/", "/list"})
    public String getCopies(Model pModel){
        pModel.addAttribute("copies", bookCopyService.getAll());
        return "copies/list";
    }

    @RequestMapping("/{id}")
    public String getCopy(@PathVariable int id, Model pModel){
        BookCopy vCopy = bookCopyService.getById(id);
        if(vCopy == null){
            return "redirect:/copies/list";
        }
        pModel.addAttribute("copy", vCopy);
        return "copies/details";
    }

    @RequestMapping("/new")
    public String newCopy(Model pModel){
        pModel.addAttribute("copy", new BookCopy());
        return "copies/form";
    }

    @RequestMapping("/edit/{id}")
    public String editCopy(@PathVariable int id, Model pModel){
        BookCopy vCopy = bookCopyService.getById(id);
        if(vCopy == null){
            return "redirect:/copies/list";
        }
        pModel.addAttribute("copy", vCopy);

        return "copies/form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCopy(@PathVariable int id){
        bookCopyService.deleteById(id);
        return "redirect:/copies/list";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String saveOrUpdateCopy(@Valid @ModelAttribute("copy") BookCopy pCopy,
                                      BindingResult bindingResult){

        Book book = pCopy.getBook();

        System.out.println("\n\n\n" + book + "\n\n\n");
//        if(bindingResult.hasErrors()){
//            return "copies/form";
//        }
        BookCopy copy = bookCopyService.save(pCopy);
        return "redirect:/copies/"+ copy.getId();
    }

}
