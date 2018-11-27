package com.opc.projet.gestionbiblio.webapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookcopy")
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "date_of_purchase")
    private String dateOfPurchase;

    // a Book is not deleted when the copy is deleted
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "book_id")
    private Book book;



    public BookCopy() {
    }

    public BookCopy(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                ", book=" + book +
                '}';
    }
}
