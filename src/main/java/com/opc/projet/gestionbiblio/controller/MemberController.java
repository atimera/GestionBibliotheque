package com.opc.projet.gestionbiblio.controller;

import com.opc.projet.gestionbiblio.model.Member;
import com.opc.projet.gestionbiblio.service.contract.MemberService;
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
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @RequestMapping({"", "/", "/list"})
    public String getMembers(Model pModel){
        pModel.addAttribute("members", memberService.getAll());
        return "members/list";
    }

    @RequestMapping("/{id}")
    public String getMember(@PathVariable int id, Model pModel){
        Member vMember = memberService.getById(id);
        if(vMember == null){
            return "redirect:/members/list";
        }
        pModel.addAttribute("member", vMember);
        return "members/details";
    }

    @RequestMapping("/new")
    public String newMember(Model pModel){
        pModel.addAttribute("member", new Member());
        return "members/form";
    }

    @RequestMapping("/edit/{id}")
    public String editMember(@PathVariable int id, Model pModel){
        Member vMember = memberService.getById(id);
        if(vMember == null){
            return "redirect:/members/list";
        }
        pModel.addAttribute("member", vMember);

        return "members/form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteMember(@PathVariable int id){
        memberService.deleteById(id);
        return "redirect:/members/list";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String saveOrUpdateMember(@Valid @ModelAttribute("member") Member pMember,
                                      BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "members/form";
        }
        Member member = memberService.save(pMember);
        System.out.println("\n\n\n" + pMember + "\n\n\n");
        return "redirect:/members/"+ member.getId();
    }

}
