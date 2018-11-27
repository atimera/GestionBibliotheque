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

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "lender_id")
    private Member lender;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private Employee lendBy;

    @Column(name = "date_of_lend")
    private String dateOfLend;

    @Column(name = "date_of_return")
    private String dateOfReturn;

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

    public Member getLender() {
        return lender;
    }

    public void setLender(Member lender) {
        this.lender = lender;
    }

    public Employee getLendBy() {
        return lendBy;
    }

    public void setLendBy(Employee lendBy) {
        this.lendBy = lendBy;
    }

    public String getDateOfLend() {
        return dateOfLend;
    }

    public void setDateOfLend(String dateOfLend) {
        this.dateOfLend = dateOfLend;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }



}
