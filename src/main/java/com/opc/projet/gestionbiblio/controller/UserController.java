package com.opc.projet.gestionbiblio.controller;

import com.opc.projet.gestionbiblio.model.User;
import com.opc.projet.gestionbiblio.service.contract.UserService;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping({"", "/", "/list"})
    public String getUsers(Model pModel){
        pModel.addAttribute("users", userService.getAll());
        return "users/list";
    }

    @RequestMapping("/{id}")
    public String getUser(@PathVariable int id, Model pModel){
        User vUser = userService.getById(id);
        if(vUser == null){
            return "redirect:/users/list";
        }
        pModel.addAttribute("user", vUser);
        return "users/details";
    }

    @RequestMapping("/new")
    public String newUser(Model pModel){
        pModel.addAttribute("user", new User());
        return "users/form";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable int id, Model pModel){
        User vUser = userService.getById(id);
        if(vUser == null){
            return "redirect:/users/list";
        }
        pModel.addAttribute("user", vUser);

        return "users/form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteById(id);
        return "redirect:/users/list";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String saveOrUpdateUser(@Valid @ModelAttribute("user") User pUser,
                                      BindingResult bindingResult){

        System.out.println("\n\n\n" + pUser + "\n\n\n");
//        if(bindingResult.hasErrors()){
//            return "users/form";
//        }
        User user = userService.save(pUser);
        return "redirect:/users/"+ user.getId();
    }

}
