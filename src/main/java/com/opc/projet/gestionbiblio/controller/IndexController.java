package com.opc.projet.gestionbiblio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(){

        return "page/home";
    }


}
