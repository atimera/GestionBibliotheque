package com.opc.projet.gestionbiblio.service.contract;

import com.opc.projet.gestionbiblio.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    List<Member> getAll();
    Member getById(long id);
    Member save(Member member);
    void deleteById(long id);

}
