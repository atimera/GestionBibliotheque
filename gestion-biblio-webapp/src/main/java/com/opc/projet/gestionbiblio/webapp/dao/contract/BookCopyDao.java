package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.BookCopy;

import java.util.List;

public interface BookCopyDao {

    public List<BookCopy> getAll();

    public void save(BookCopy bookCopy);

    public void update(BookCopy bookCopy);

    public BookCopy get(Integer id);

    public void delete(Integer id);

}
