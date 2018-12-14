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
        //@NamedQuery(name = "find_all_authors", query = "select a from Auhthor a")
})
@NoArgsConstructor
@AllArgsConstructor
public class Author extends Person {

    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        if(books==null){
            books = new ArrayList<>();
        }
        books.add(book);
    }

    public void removeBook (Book pBook){
        if(books != null){
            books.remove(pBook);
        }
    }


    @Override
    public String toString() {
        return "\nAuthor - {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                '}';
    }
}
