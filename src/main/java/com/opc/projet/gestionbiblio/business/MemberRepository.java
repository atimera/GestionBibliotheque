package com.opc.projet.gestionbiblio.business;

import com.opc.projet.gestionbiblio.model.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
@Repository
@Transactional
public class MemberRepository {

    // for connection to the db
    @PersistenceContext
    EntityManager em;

    // === find all
    public List<Member> findAll(){

        TypedQuery<Member> namedQuery = em.createNamedQuery("find_all_members", Member.class);
        return namedQuery.getResultList();
    }

    // === find by id
    public Member findById(long id){
        return em.find(Member.class, id);
    }

    // === insert / update
    public Member save(Member member){
        if(member.getId() == null){
            em.persist(member);
        }else {
            em.merge(member);
        }
        return member;
    }

    // === delete by id
    public void deletById(long id){
        Member member = findById(id);
        if(member != null)
            em.remove(member);
    }



}
