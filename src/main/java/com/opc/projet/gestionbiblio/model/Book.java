package com.opc.projet.gestionbiblio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Entity
@NamedQueries({
        @NamedQuery(name = "find_all_books", query = "select b from Book b"),
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String dateOfPublication;
    private String cover;


    @JsonIgnore
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "book",
            cascade = {CascadeType.ALL})
    private List<BookCopy> copies;


    @JsonIgnore
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "library_id")
    private Library library;

    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    List<Author> authors;




    // convenience methods for bi-directional relationship

//    public void addCopy (BookCopy bookCopy){
//        if(copies == null){
//            copies = new ArrayList<>();
//        }
//        // set the link
//        copies.add(bookCopy);
//        bookCopy.setBook(this);
//    }

}
