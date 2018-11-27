package com.opc.projet.gestionbiblio.webapp.controller;

import com.opc.projet.gestionbiblio.webapp.dao.contract.MemberDao;
import com.opc.projet.gestionbiblio.webapp.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {



    @Autowired
    private MemberDao memberDao;

    @RequestMapping("/list")
    public String listMember(Model theModel){

        // get members from the dao
        List<Member> theMembers = memberDao.getMembers();

        // add members the spring mvc model
        theModel.addAttribute("members", theMembers);

        return "list-members";
    }

    @RequestMapping("showForm")
    public String showForm(Model theModel){

        theModel.addAttribute("member", new Member());

        return "member-form";
    }

    @RequestMapping("processForm")
    public String processForm(@Valid @ModelAttribute("member") Member theMember,
                              BindingResult bindingResult){

        // TODO: 26/11/2018  
        
        if (bindingResult.hasErrors()){
            return "member-form";
        }else {
            return "member-confirmation";
        }
    }

	
}
