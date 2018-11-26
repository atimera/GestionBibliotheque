package com.opc.projet.gestionbiblio.webapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_of_purchase")
    private Date dateOfPurchase;

    // a Book is not deleted when the copy is deleted
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "book_id")
    private Book book;



    public BookCopy() {
    }

    public BookCopy(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
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
                ", dateOfPurchase=" + dateOfPurchase +
                '}';
    }
}
