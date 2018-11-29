package com.opc.projet.gestionbiblio.webapp.service.rest.controller;

import com.opc.projet.gestionbiblio.webapp.entity.Member;
import com.opc.projet.gestionbiblio.webapp.service.rest.exception.MemberNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberRestController {

    private  List<Member> membersList;


    @PostConstruct
    private void loadData(){ // called only once when this bean is constructed

        membersList = new ArrayList<>();

        membersList.add(new Member("Hamza", "Timéra", "hamza@hotmail.fr"));
        membersList.add(new Member("Mouss", "Dramé", "moussa@hotmail.fr"));
        membersList.add(new Member("Fatou", "Touré", "mabelle@hotmail.fr"));
        membersList.add(new Member("Paul", "Sifesalam", "paul@gmail.fr"));

    }

    @GetMapping("/members")
    public List<Member> members(){
        return membersList;
    }

    @GetMapping("/members/{memberId}")
    public Member getMember(@PathVariable int memberId){

        if(memberId >= membersList.size() || memberId < 0){
            throw new MemberNotFoundException("Member is not found - " + memberId );
        }

        return members().get(memberId) ;
    }

}
