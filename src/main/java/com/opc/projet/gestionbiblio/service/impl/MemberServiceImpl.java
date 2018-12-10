package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.business.contract.MemberRepository;
import com.opc.projet.gestionbiblio.model.Member;
import com.opc.projet.gestionbiblio.model.Member;
import com.opc.projet.gestionbiblio.service.contract.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository repository;

    @Override
    public List<Member> getAll() {
        return repository.findAll();
    }

    @Override
    public Member getById(long pId) {
        Member vMember = null;
        Optional<Member> optional = repository.findById(pId);

        if(optional.isPresent()){
            vMember = optional.get();
        }
        return vMember;
    }


    @Override
    public Member save(Member member) {
        return repository.save(member);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
