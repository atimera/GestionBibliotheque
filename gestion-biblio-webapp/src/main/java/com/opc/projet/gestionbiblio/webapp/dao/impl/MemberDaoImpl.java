//package com.opc.projet.gestionbiblio.webapp.dao.impl;
//
//import com.opc.projet.gestionbiblio.webapp.dao.contract.MemberDao;
//import com.opc.projet.gestionbiblio.webapp.entity.Member;
//import com.opc.projet.gestionbiblio.webapp.entity.Person;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class MemberDaoImpl implements MemberDao {
//
//    @Autowired
//    SessionFactory sessionFactory;
//
//    @Override
//    public List<Member> getAll() {
//
//        return sessionFactory.getCurrentSession()
//                .createQuery("SELECT m FROM Member m", Member.class)
//                .getResultList();
//
//    }
//
//    @Override
//    public void save(Member member) {
//
//        try {
//            sessionFactory.getCurrentSession().save(member);
//        } catch (Exception ignored) {
//        }
//
//    }
//
//    public void update(Member member) {
//        try {
//            sessionFactory.getCurrentSession().update(member);
//        } catch (Exception ignored) {
//        }
//    }
//
//    @Override
//    public Member get(Integer id) {
//        return sessionFactory.getCurrentSession().get(Member.class, id);
//    }
//
//    @Override
//    public void delete(Integer id) {
//        try {
//            sessionFactory.getCurrentSession().delete(id);
//        } finally {
//            sessionFactory.close();
//        }
//    }
//}
