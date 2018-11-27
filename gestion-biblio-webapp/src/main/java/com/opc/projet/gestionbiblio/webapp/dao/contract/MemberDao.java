package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Member;

import java.util.List;


public interface MemberDao {

    public List<Member> getAll();

    public void save(Member book);

    public void update(Member book);

    public Member get(Integer id);

    public void delete(Integer id);
}
