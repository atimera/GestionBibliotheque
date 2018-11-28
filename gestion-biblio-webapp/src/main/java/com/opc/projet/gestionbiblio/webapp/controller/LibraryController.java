//package com.opc.projet.gestionbiblio.webapp.controller;
//
//import com.opc.projet.gestionbiblio.webapp.dao.contract.LibraryDao;
//import com.opc.projet.gestionbiblio.webapp.entity.Address;
//import com.opc.projet.gestionbiblio.webapp.entity.Library;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//@RequestMapping("/library")
//public class LibraryController {
//
//
//    @Autowired
//    private LibraryDao libraryDao;
//
//    @RequestMapping("/list")
//    public String list(Model theModel){
//
//        List<Library> theLibraries;
//
//        theLibraries = libraryDao.list();
//
//        theModel.addAttribute("libraries",theLibraries);
//
//
//        return "list-libraries";
//    }
//
//
//    @RequestMapping("/showForm")
//    public String showForm(Model theModel){
//
//        Library theLibrary = new Library();
//        Address theAddress = new Address();
//
//        theLibrary.setAddress(theAddress);
//
//        theModel.addAttribute("library", theLibrary);
//
//        return "library-form";
//    }
//
//    @RequestMapping("/processForm")
//    public String processForm(@Valid @ModelAttribute("library") Library theLibrary, BindingResult bindingResult){
//
//        if (bindingResult.hasErrors()){
//            return "library-form";
//        }else{
//
//            // save the library
//            Address address = new Address("20 Avenue de paris", "75001", "Paris");
//            theLibrary.setAddress(address);
//
//            libraryDao.add(theLibrary);
//
//            // TODO: 25/11/2018
//            //libraryDao.add(theLibrary);
//
//            //return "library-confirmation";
//        }
//        return "library-confirmation";
//    }
//}
