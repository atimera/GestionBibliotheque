package com.opc.projet.gestionbiblio.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/showAdmins")
    public String showAdmins(){
        return "admins";
    }

    @GetMapping("/showLeaders")
    public String showLeaders(){
        return "leaders";
    }

    @GetMapping("/showEmployees")
    public String showEmployees(){
        return "employees";
    }


}
