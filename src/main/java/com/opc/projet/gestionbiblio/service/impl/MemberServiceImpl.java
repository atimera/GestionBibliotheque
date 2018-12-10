package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.MemberRepository;
import com.opc.projet.gestionbiblio.model.Member;
import com.opc.projet.gestionbiblio.service.contract.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository repository;

    @Override
    public List<Member> getAll() {
        return repository.findAll();
    }

    @Override
    public Member getById(long id) {
        return repository.findById(id);
    }

    @Override
    public Member save(Member member) {
        return repository.save(member);
    }

    @Override
    public void deleteById(long id) {
        repository.deletById(id);
    }
}
