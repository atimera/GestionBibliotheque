package com.opc.projet.gestionbiblio.webapp.controller;


import com.opc.projet.gestionbiblio.webapp.entity.Member;
import com.opc.projet.gestionbiblio.webapp.entity.Person;
import com.opc.projet.gestionbiblio.webapp.service.contract.MemberService;
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
@RequestMapping("/member")
public class MemberController {


    @Autowired
    private MemberService memberService;

    @GetMapping("/list")
    public String listMember(Model theModel){

        List<Member> theMembers = memberService.getAll();
        theModel.addAttribute("members", theMembers);
        return "member-list";
    }

    @GetMapping("/showForm")
    public String showForm(Model theModel){

        Person theMember = new Member();
        theModel.addAttribute("member", new Member());
        return "member-form";
    }

    @PostMapping("/add")
    public String processForm(@Valid @ModelAttribute("member") Member theMember,
                              BindingResult bindingResult){

        memberService.save(theMember);
        return "redirect:/member/list";
    }


}
