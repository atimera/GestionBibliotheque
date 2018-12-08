package com.opc.projet.gestionbiblio.model;

import lombok.*;

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

    // when a book is deleted, all it's copies will be deleted
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<BookCopy> copies;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    List<Author> authors;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

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

}
