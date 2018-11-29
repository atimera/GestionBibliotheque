package com.opc.projet.gestionbiblio.webapp.service.rest;

import com.opc.projet.gestionbiblio.webapp.entity.Member;
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

    private  List<Member> members;


    @PostConstruct
    private void loadData(){ // called only once when this bean is constructed

        members = new ArrayList<>();

        members.add(new Member("Hamza", "Timéra", "hamza@hotmail.fr"));
        members.add(new Member("Mouss", "Dramé", "moussa@hotmail.fr"));
        members.add(new Member("Fatou", "Touré", "mabelle@hotmail.fr"));
        members.add(new Member("Paul", "Sifesalam", "paul@gmail.fr"));

    }

    @GetMapping("/members")
    public List<Member> members(){
        return members;
    }

    @GetMapping("/members/{memberId}")
    public Member getMember(@PathVariable int memberId){
        return members().get(memberId) ;
    }

}
