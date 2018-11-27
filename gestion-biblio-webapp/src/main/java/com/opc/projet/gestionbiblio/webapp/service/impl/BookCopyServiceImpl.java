package com.opc.projet.gestionbiblio.webapp.service.impl;

import com.opc.projet.gestionbiblio.webapp.dao.contract.BookCopyDao;
import com.opc.projet.gestionbiblio.webapp.entity.BookCopy;
import com.opc.projet.gestionbiblio.webapp.service.contract.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookCopyServiceImpl implements BookCopyService {

    @Autowired
    private BookCopyDao bookCopyDao;

    @Override
    @Transactional
    public List<BookCopy> getAll() {
        return  bookCopyDao.getAll();
    }

    @Override
    @Transactional
    public BookCopy get(Integer id) {
        return bookCopyDao.get(id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        bookCopyDao.delete(id);
    }

    @Override
    @Transactional
    public void save(BookCopy book) {
        bookCopyDao.save(book);
    }

    @Override
    @Transactional
    public void update(BookCopy book) {
        bookCopyDao.update(book);
    }


}
