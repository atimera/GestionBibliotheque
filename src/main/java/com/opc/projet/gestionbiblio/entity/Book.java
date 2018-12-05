//package com.opc.projet.gestionbiblio.entity;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "book")
//public class Book {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "title")
//    private String title;
//
//    @Column(name = "date_of_publication")
//    private String dateOfPublication;
//
//    // when a book is deleted, all it's copies will be deleted
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = {CascadeType.ALL})
//    private List<BookCopy> copies;
//
//    public Book() {
//    }
//
//    public Book(String title, String dateOfPublication) {
//        this.title = title;
//        this.dateOfPublication = dateOfPublication;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDateOfPublication() {
//        return dateOfPublication;
//    }
//
//    public void setDateOfPublication(String dateOfPublication) {
//        this.dateOfPublication = dateOfPublication;
//    }
//
//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", dateOfPublication=" + dateOfPublication +
//                '}';
//    }
//
//    public List<BookCopy> getCopies() {
//        return copies;
//    }
//
//    public void setCopies(List<BookCopy> copies) {
//        this.copies = copies;
//    }
//
//
//    // convenience methods for bi-directional relationship
//
//    public void addCopy (BookCopy bookCopy){
//        if(copies == null){
//            copies = new ArrayList<>();
//        }
//        // set the link
//        copies.add(bookCopy);
//        bookCopy.setBook(this);
//    }
//
//}
