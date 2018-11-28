//package com.opc.projet.gestionbiblio.webapp.service.impl;
//
//import com.opc.projet.gestionbiblio.webapp.dao.contract.BookDao;
//import com.opc.projet.gestionbiblio.webapp.entity.Book;
//import com.opc.projet.gestionbiblio.webapp.service.contract.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class BookServiceImpl implements BookService {
//
//    @Autowired
//    private BookDao bookDao;
//
//    @Override
//    @Transactional
//    public List<Book> getAll() {
//        return  bookDao.getAll();
//    }
//
//    @Override
//    @Transactional
//    public Book get(Integer id) {
//        return bookDao.get(id);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Integer id) {
//        bookDao.delete(id);
//    }
//
//    @Override
//    @Transactional
//    public void save(Book book) {
//        bookDao.save(book);
//    }
//
//    @Override
//    @Transactional
//    public void update(Book book) {
//        bookDao.update(book);
//    }
//
//}
