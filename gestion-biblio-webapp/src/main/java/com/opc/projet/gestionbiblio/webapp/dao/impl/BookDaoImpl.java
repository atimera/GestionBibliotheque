//package com.opc.projet.gestionbiblio.webapp.dao.impl;
//
//import com.opc.projet.gestionbiblio.webapp.dao.contract.BookDao;
//import com.opc.projet.gestionbiblio.webapp.entity.Book;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.Date;
//import java.util.List;
//
//@Repository
//public class BookDaoImpl implements BookDao {
//
//    @Autowired
//    SessionFactory sessionFactory;
//
//    @Override
//    public List<Book> getAll() {
//
//        return sessionFactory.getCurrentSession()
//                .createQuery("from Book", Book.class)
//                .getResultList();
//
//    }
//
//    @Override
//    public void save(Book book) {
//
//        try {
//            sessionFactory.getCurrentSession().save(book);
//        }catch (Exception ignored){ }
//
//    }
//
//    public void update(Book book){
//        try {
//            sessionFactory.getCurrentSession().update(book);
//        }catch (Exception ignored){ }
//    }
//
//    @Override
//    public Book get(Integer id) {
//        return sessionFactory.getCurrentSession().get(Book.class, id);
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
//}
