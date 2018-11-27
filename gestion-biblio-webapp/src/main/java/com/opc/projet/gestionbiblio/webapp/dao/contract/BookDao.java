package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Book;

import java.util.List;

public interface BookDao {

    public List<Book> getAll();

    public void save(Book book);

    public void update(Book book);

    public Book get(Integer id);

    public void delete(Integer id);

}
