package com.opc.projet.gestionbiblio.model;

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


    @Override
    public String toString() {
        return "BookCopy{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                '}';
    }
}
