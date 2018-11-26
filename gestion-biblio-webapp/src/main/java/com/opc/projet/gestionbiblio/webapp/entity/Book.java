package com.opc.projet.gestionbiblio.webapp.entity;

import java.util.Date;
import java.util.List;

public class Book {


    private Integer id;
    private String title;
    private Date dateOfPublication;
    private List<Author> authors;
    private List<BookCopy> copies;




}
