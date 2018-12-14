package com.opc.projet.gestionbiblio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Entity
@NamedQueries({
        @NamedQuery(name = "find_all_books", query = "select b from Book b"),
})
@NoArgsConstructor
@AllArgsConstructor
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
            cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
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



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public List<BookCopy> getCopies() {
        return copies;
    }

    public void setCopies(List<BookCopy> copies) {
        this.copies = copies;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }


    // convenience methods for bi-directional relationship

//    public void addCopy (BookCopy bookCopy){
//        if(copies == null){
//            copies = new ArrayList<>();
//        }
//        // set the link
//        copies.add(bookCopy);
//        bookCopy.setBook(this);
//    }

    public void addAuthor (Author pAuthor){
        if(authors == null){
            authors = new ArrayList<>();
        }
        // set the link
        authors.add(pAuthor);
    }
    public void removeAuthor (Author pAuthor){
        if(authors != null){
            authors.remove(pAuthor);
        }
    }




    @Override
    public String toString() {
        return "\nBook - {" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateOfPublication='" + dateOfPublication + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}
