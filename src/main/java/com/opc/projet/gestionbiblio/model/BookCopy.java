package com.opc.projet.gestionbiblio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@SuppressWarnings("JpaQlInspection")
@Entity
@NamedQueries({
        @NamedQuery(name = "find_all_copies", query = "select c from BookCopy c"),
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "bookcopy")
public class BookCopy {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "date_of_purchase")
    private String dateOfPurchase;

    private Boolean isLended;

    @Column(name = "date_of_lend")
    private String dateOfLend;

    @Column(name = "date_of_return")
    private String dateOfReturn;


    // a Book is not deleted when the copy is deleted
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "book_id")
    private Book book;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "lender_id")
    private Member lender;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private Employee lendBy;



}
