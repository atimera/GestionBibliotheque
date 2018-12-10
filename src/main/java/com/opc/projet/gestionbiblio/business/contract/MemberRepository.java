package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
public interface MemberRepository extends JpaRepository<Member, Long> {

//
//    // === find all
//    public List<Member> findAll();
//
//    // === find by id
//    public Member findById(long id);
//
//    // === insert / update
//    public Member save(Member member);
//
//    // === delete by id
//    public void deletById(long id);



}
