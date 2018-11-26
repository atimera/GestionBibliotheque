package com.opc.projet.gestionbiblio.webapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "date_of_publication")
    private Date dateOfPublication;

    // when a book is deleted, all it's copies will be deleted
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookCopy> copies;

    public Book() {
    }

    public Book(String title, Date dateOfPublication) {
        this.title = title;
        this.dateOfPublication = dateOfPublication;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateOfPublication=" + dateOfPublication +
                '}';
    }

    public List<BookCopy> getCopies() {
        return copies;
    }

    public void setCopies(List<BookCopy> copies) {
        this.copies = copies;
    }

    // convenience methods for bi-directional relationship

    public void add (BookCopy bookCopy){
        if(copies == null){
            copies = new ArrayList<>();
        }
        copies.add(bookCopy);
        bookCopy.setBook(this);
    }

}
