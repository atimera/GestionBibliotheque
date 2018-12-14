package com.opc.projet.gestionbiblio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("JpaQlInspection")
@Entity
@AllArgsConstructor
@Table(name = "bookcopy")
public class BookCopy {

    @Id
    @GeneratedValue
    private Long id;
    private String reference;
    private String dateOfPurchase;
    private Boolean available;
    private String dateOfLend;
    private String dateOfReturn;

    public BookCopy(){
        super();
        available = true;
    }


    // a Book is not deleted when the copy is deleted
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "book_id")
    private Book book;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "member_id")
    private Member borrower;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private Employee lender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getBorrower() {
        return borrower;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
    }

    public Employee getLender() {
        return lender;
    }

    public void setLender(Employee lender) {
        this.lender = lender;
    }
}
