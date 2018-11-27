package com.opc.projet.gestionbiblio.webapp.dao.impl;

import com.opc.projet.gestionbiblio.webapp.dao.contract.MemberDao;
import com.opc.projet.gestionbiblio.webapp.entity.Member;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDaoImpl implements MemberDao {

    // nend to inject session Factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Member> getMembers() {

//        // get the current hibernate session
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        EntityManager entityManager = sessionFactory.createEntityManager();
//
//        // create a query
//        //Query<Member> theQuery = currentSession.createQuery("select a from Member a", Member.class);
//
//        // executre query and get results
//        String sql = "select c from Member c";
//        List<Member> results = entityManager.createQuery(sql, Member.class).getResultList();
//
//        if(results == null){
//            System.out.println( "\nPAS de Résultalt\n");
//        }
//
//        // return the list
//        return results;

        // for example without db
        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member("John", "Doe", "john.doe@gmail.com"));
        memberList.add(new Member("Franc", "Leroy", "leroy.franc@gmail.com"));
        memberList.add(new Member("Moise", "Camara", "moise.camara@hotmail.com"));
        return memberList;
    }

}
