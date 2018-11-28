//package com.opc.projet.gestionbiblio.webapp.service.impl;
//
//import com.opc.projet.gestionbiblio.webapp.dao.contract.MemberDao;
//import com.opc.projet.gestionbiblio.webapp.entity.Member;
//import com.opc.projet.gestionbiblio.webapp.service.contract.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class MemberServiceImpl implements MemberService {
//
//    @Autowired
//    private MemberDao memberDao;
//
//    @Override
//    @Transactional
//    public List<Member> getAll() {
//        return  memberDao.getAll();
//    }
//
//    @Override
//    @Transactional
//    public Member get(Integer id) {
//        return memberDao.get(id);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Integer id) {
//        memberDao.delete(id);
//    }
//
//    @Override
//    @Transactional
//    public void save(Member member) {
//        memberDao.save(member);
//    }
//
//    @Override
//    @Transactional
//    public void update(Member member) {
//        memberDao.update(member);
//    }
//
//}
