package com.opc.projet.gestionbiblio.controller;

import com.opc.projet.gestionbiblio.model.Library;
import com.opc.projet.gestionbiblio.service.contract.LibraryService;
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
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @RequestMapping({"", "/", "/list"})
    public String getLibraries(Model pModel){
        pModel.addAttribute("libraries", libraryService.getAll());
        return "libraries/list";
    }

    @RequestMapping("/{id}")
    public String getLibrary(@PathVariable int id, Model pModel){
        Library vLibrary = libraryService.getById(id);
        if(vLibrary == null){
            return "redirect:/libraries/list";
        }
        pModel.addAttribute("library", vLibrary);
        return "libraries/details";
    }

    @RequestMapping("/new")
    public String newLibrary(Model pModel){
        pModel.addAttribute("library", new Library());
        return "libraries/form";
    }

    @RequestMapping("/edit/{id}")
    public String editLibrary(@PathVariable int id, Model pModel){
        Library vLibrary = libraryService.getById(id);
        if(vLibrary == null){
            return "redirect:/libraries/list";
        }
        pModel.addAttribute("library", vLibrary);

        return "libraries/form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteLibrary(@PathVariable int id){
        libraryService.deleteById(id);
        return "redirect:/libraries/list";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String saveOrUpdateLibrary(@Valid @ModelAttribute("library") Library pLibrary,
                                      BindingResult bindingResult){

        System.out.println("\n\n\n" + pLibrary + "\n\n\n");
//        if(bindingResult.hasErrors()){
//            return "libraries/form";
//        }
        Library library = libraryService.save(pLibrary);
        return "redirect:/libraries/"+ library.getId();
    }

    @RequestMapping("/{id}/employees")
    public String getLibraryEmployees(@PathVariable long id, Model pModel){
        Library vLibrary = libraryService.getById(id);
        if(vLibrary == null){
            return "redirect:/libraries/list";
        }
        pModel.addAttribute("employees", vLibrary.getEmployees());
        return "libraries/employees-list";
    }

    @RequestMapping("/{id}/members")
    public String getLibraryMembers(@PathVariable long id, Model pModel){
        Library vLibrary = libraryService.getById(id);
        if(vLibrary == null){
            return "redirect:/libraries/list";
        }
        pModel.addAttribute("members", vLibrary.getMembers());
        return "libraries/members-list";
    }

    @RequestMapping("/{id}/books")
    public String getLibraryBooks(@PathVariable long id, Model pModel){
        Library vLibrary = libraryService.getById(id);
        if(vLibrary == null){
            return "redirect:/libraries/list";
        }
        pModel.addAttribute("books", vLibrary.getBooks());
        return "libraries/books-list";
    }



}
