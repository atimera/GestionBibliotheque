package com.opc.projet.gestionbiblio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@SuppressWarnings("JpaQlInspection")
@Entity
@NamedQueries({
        @NamedQuery(name = "find_all_employees", query = "select e from Employee e"),
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Employee extends User{

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "library_id")
    private Library library;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "lendBy",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
    private List<BookCopy> lendedCopies;


//    // inconvenience methods for bi-directional relationship
//
//    public void addLendedCopy(BookCopy copy){
//        if(lendedCopies == null){
//            lendedCopies = new ArrayList<>();
//        }
//        // set the link
//        lendedCopies.add(copy);
//        copy.setLendBy(this);
//    }
//

}
