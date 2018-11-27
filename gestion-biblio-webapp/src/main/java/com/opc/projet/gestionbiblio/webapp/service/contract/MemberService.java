package com.opc.projet.gestionbiblio.webapp.service.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAll();

    Member get(Integer id);

    void delete(Integer id);

    void save(Member book);

    void update(Member book);


}
