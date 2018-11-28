//package com.opc.projet.gestionbiblio.webapp.dao.impl;
//
//import com.opc.projet.gestionbiblio.webapp.dao.contract.BookCopyDao;
//import com.opc.projet.gestionbiblio.webapp.entity.BookCopy;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class BookCopyDoaImpl implements BookCopyDao {
//
//    @Autowired
//    SessionFactory sessionFactory;
//
//    @Override
//    public List<BookCopy> getAll() {
//
//        return sessionFactory.getCurrentSession()
//                .createQuery("from BookCopy", BookCopy.class)
//                .getResultList();
//
//    }
//
//    @Override
//    public void save(BookCopy bookCopy) {
//
//        sessionFactory.getCurrentSession().save(bookCopy);
//
//    }
//
//    public void update(BookCopy copy){
//        try {
//            sessionFactory.getCurrentSession().update(copy);
//        }finally {
//            sessionFactory.close();
//        }
//    }
//
//    @Override
//    public BookCopy get(Integer id) {
//        return sessionFactory.getCurrentSession().get(BookCopy.class, id);
//    }
//
//    @Override
//    public void delete(Integer id) {
//        try {
//            sessionFactory.getCurrentSession().delete(id);
//        }finally {
//            sessionFactory.close();
//        }
//    }
//
//}
