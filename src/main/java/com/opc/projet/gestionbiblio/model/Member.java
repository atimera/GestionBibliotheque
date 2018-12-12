package com.opc.projet.gestionbiblio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@SuppressWarnings("JpaQlInspection")
@Entity
@NamedQueries({
        @NamedQuery(name = "find_all_members", query = "select m from Member m"),
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(value = {"libraries", "lendedCopies"})
public class Member extends User{

    @JsonIgnore
    @OneToMany(mappedBy = "lender", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<BookCopy> lendedCopies;

    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "library_member",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "library_id"))
    private List<Library> libraries;




    // inconvenience methods for bi-directional relationship

//    public void addLibrary(Library library) {
//        if(libraries == null){
//            libraries = new ArrayList<>();
//        }
//        // set the link
//        libraries.add(library);
//        library.addMember(this);
//    }
//
//    public void addBookCopy(BookCopy copy){
//        if(lendedCopies == null){
//            lendedCopies = new ArrayList<>();
//        }
//        // set the link
//        lendedCopies.add(copy);
//        copy.setLender(this);
//    }


}
