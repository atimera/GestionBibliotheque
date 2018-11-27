package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Member;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface MemberDao {

    @Transactional
    List<Member> getMembers();
}
