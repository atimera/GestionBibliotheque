package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Book;

import java.util.List;

public interface AuthorRepositoryCustom {
    List<Book> findAuthorBooks(long authorId);
    Book findAuthorBookById(long authorId, long bookId);
    int deleteBookFromBooks(long authorId, long bookId);

}
