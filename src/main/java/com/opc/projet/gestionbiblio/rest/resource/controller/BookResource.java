package com.opc.projet.gestionbiblio.rest.resource.controller;

import com.opc.projet.gestionbiblio.business.contract.BookCopyRepository;
import com.opc.projet.gestionbiblio.business.contract.BookRepository;
import com.opc.projet.gestionbiblio.model.Author;
import com.opc.projet.gestionbiblio.model.Book;
import com.opc.projet.gestionbiblio.model.BookCopy;
import com.opc.projet.gestionbiblio.rest.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping("/api")
public class BookResource {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookCopyRepository bookCopyRepository;


    // retrieve list of all books
    @GetMapping("/books")
    public List<Book> retrieveBooks(){

        return bookRepository.findAll();
    }


    // get a single book by id
    @GetMapping("/books/{pId}")
    public Resource<Book> retrieveBook(@PathVariable long pId){

        Optional<Book> optionalBook = bookRepository.findById(pId);
        if(!optionalBook.isPresent()) throw new NotFoundException("Book not found : id - " + pId);


        // HATEOAS
        Resource<Book> bookResource = new Resource<>(optionalBook.get());

        ControllerLinkBuilder linkToBooks = linkTo(methodOn(this.getClass()).retrieveBooks());
        bookResource.add(linkToBooks.withRel("all-books"));

        ControllerLinkBuilder linkToAuthors = linkTo(methodOn(this.getClass()).retrieveBookAuthors(pId));
        bookResource.add(linkToAuthors.withRel("book-authors"));

        ControllerLinkBuilder linkToCopies = linkTo(methodOn(this.getClass()).retrieveBookCopies(pId));
        bookResource.add(linkToCopies.withRel("book-copies"));

        return bookResource;
    }


    // create book
    @PostMapping("/books") // or @PutMapping
    public ResponseEntity<Object> createBook(@Valid @RequestBody Book pBook){

        Book vBook = bookRepository.save(pBook);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vBook.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/books/{pId}")
    public void deleteBook(@PathVariable long pId){
        if(!bookRepository.findById(pId).isPresent()) throw new NotFoundException("Book does not exist id-"+pId);
        bookRepository.deleteById(pId);

    }


    // ========================================= //
    // == TODO: 12/12/2018 update not working == //
    // ========================================= //
    // update book
    @PatchMapping("/books/{pId}")
    public ResponseEntity<Object> updateBook(
            @Valid @RequestBody Book pBook,
            @PathVariable("pId") long pId){

        Optional<Book> optionalBook = bookRepository.findById(pId);
        if(!optionalBook.isPresent()){
            throw new NotFoundException("Book not found : id - "+ pId);
        }

        Book vBook = bookRepository.save(pBook);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vBook.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    // retrieve list of all books
    @GetMapping("/books/{bookId}/copies")
    public List<BookCopy> retrieveBookCopies(@PathVariable long bookId){

        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(!optionalBook.isPresent()){
            throw new NotFoundException("Book not found : id - "+ bookId);
        }

        Book vBook = optionalBook.get();

        return vBook.getCopies();

    }


    // get book's copy by id
    @GetMapping("/books/{bookId}/copies/{copyId}")
    public Resource<BookCopy> retrieveBookCopy(
            @PathVariable long bookId,
            @PathVariable long copyId){

        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(!optionalBook.isPresent()){
            throw new NotFoundException("Book not found : id - "+ bookId);
        }

        Optional<BookCopy> optionalCopy = bookCopyRepository.findById(copyId);
        if(!optionalCopy.isPresent()) throw new NotFoundException("Copy not found : id - " + copyId);

        // HATEOAS
        Resource<BookCopy> copyResource = new Resource<>(optionalCopy.get());

        ControllerLinkBuilder linkToTheBook = linkTo(methodOn(this.getClass()).retrieveBook(bookId));
        copyResource.add(linkToTheBook.withRel("the-book"));

        ControllerLinkBuilder linkToBookCopies = linkTo(methodOn(this.getClass()).retrieveBookCopies(bookId));
        copyResource.add(linkToBookCopies.withRel("book-copies"));


        return copyResource;
    }


    // create book's copy
    @PostMapping("/books/{bookId}/copies") // or @PutMapping
    public ResponseEntity<Object> createBookCopy(@PathVariable long bookId,
                                                 @Valid @RequestBody BookCopy pBookCopy){

        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(!optionalBook.isPresent()) throw new NotFoundException("Book not found : id - " + bookId);

        pBookCopy.setBook(optionalBook.get());

        BookCopy vCopy = bookCopyRepository.save(pBookCopy);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vCopy.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    // update book's copy
    @PatchMapping("/books/{bookId}/copies") // or @PutMapping
    public ResponseEntity<Object> updateBookCopy(@PathVariable long bookId,
                                                 @Valid @RequestBody BookCopy pBookCopy){

        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(!optionalBook.isPresent()) throw new NotFoundException("Book not found : id - " + bookId);

        if(pBookCopy.getBook() == null){
            pBookCopy.setBook(optionalBook.get());
        }

        BookCopy vCopy = bookCopyRepository.save(pBookCopy);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vCopy.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/books/{bookId}/copies/{copyId}")
    public void deleteBookLocation(@PathVariable long bookId, @PathVariable long copyId){

        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(!optionalBook.isPresent()) throw new NotFoundException("Book not found : id - " + bookId);

        Optional<BookCopy> optionalBookCopy = bookCopyRepository.findById(copyId);
        if(!optionalBookCopy.isPresent()) throw new NotFoundException("Copy does not : id - " + copyId);

        optionalBook.get().getCopies().remove(optionalBookCopy.get());

        bookCopyRepository.deleteById(copyId);
    }


    // retrieve list of book's authors
    @GetMapping("/books/{bookId}/authors")
    public List<Author> retrieveBookAuthors(@PathVariable long bookId){
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (!optionalBook.isPresent()) throw new NotFoundException("Book not found id-"+ bookId);

        return optionalBook.get().getAuthors();
    }



}
