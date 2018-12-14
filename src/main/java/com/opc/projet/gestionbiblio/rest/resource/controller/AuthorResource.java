package com.opc.projet.gestionbiblio.rest.resource.controller;

import com.opc.projet.gestionbiblio.business.contract.AuthorRepository;
import com.opc.projet.gestionbiblio.business.contract.AuthorRepositoryCustom;
import com.opc.projet.gestionbiblio.business.contract.BookRepository;
import com.opc.projet.gestionbiblio.model.Author;
import com.opc.projet.gestionbiblio.model.Book;
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
public class AuthorResource {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorRepositoryCustom authorRepositoryCustom;

    @Autowired
    BookRepository bookRepository;
    

    // retrieve list of all authors
    @GetMapping("/authors")
    public List<Author> retrieveAuthors(){

        return authorRepository.findAll();
    }


    // get a single author by id
    @GetMapping("/authors/{pId}")
    public Resource<Author> retrieveAuthor(@PathVariable long pId){

        Optional<Author> optionalAuthor = authorRepository.findById(pId);
        if(!optionalAuthor.isPresent()){
            throw new NotFoundException("Author not found : id - "+ pId);
        }


        // HATEOAS
        Resource<Author> authorResource = new Resource<>(optionalAuthor.get());

        ControllerLinkBuilder linkToAuthors = linkTo(methodOn(this.getClass()).retrieveAuthors());
        authorResource.add(linkToAuthors.withRel("all-authors"));

        ControllerLinkBuilder linkToBooks = linkTo(methodOn(this.getClass()).retrieveAuthorBooks(pId));
        authorResource.add(linkToBooks.withRel("author-books"));

        return authorResource;
    }


    // create author
    @PostMapping("/authors") // or @PutMapping
    public ResponseEntity<Object> createAuthor(@Valid @RequestBody Author pAuthor){

        Author vAuthor = authorRepository.save(pAuthor);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vAuthor.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/authors/{pId}")
    public void deleteAuthor(@PathVariable long pId){
        if(!authorRepository.findById(pId).isPresent()) throw new NotFoundException("Author does not exist id-"+pId);
        authorRepository.deleteById(pId);

    }


    // ========================================= //
    // == TODO: 12/12/2018 update not working == //
    // ========================================= //
    // update author
    @PatchMapping("/authors/{pId}")
    public ResponseEntity<Object> updateAuthor(
            @Valid @RequestBody Author pAuthor,
            @PathVariable("pId") long pId){

        Optional<Author> optionalAuthor = authorRepository.findById(pId);
        if(!optionalAuthor.isPresent()){
            throw new NotFoundException("Author not found : id - "+ pId);
        }

        Author vAuthor = authorRepository.save(pAuthor);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vAuthor.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    // retrieve list of all author's books
    @GetMapping("/authors/{authorId}/books")
    public List<Book> retrieveAuthorBooks(@PathVariable long authorId){

        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if(!optionalAuthor.isPresent()){
            throw new NotFoundException("Author not found : id - "+ authorId);
        }

        return authorRepositoryCustom.findAuthorBooks(authorId);

    }

    // get author's book by bookId
    @GetMapping("/authors/{authorId}/books/{bookId}")
    public Resource<Book> retrieveAuthorBook(
            @PathVariable long authorId,
            @PathVariable long bookId){

        Book vBook = authorRepositoryCustom.findAuthorBookById(authorId, bookId);
        if(vBook == null) throw new NotFoundException("Book not found : authorId - "+ authorId+ " and bookId - " + bookId);

        // HATEOAS
        Resource<Book> bookResource = new Resource<>(vBook);

        ControllerLinkBuilder linkToTheAuthorBooks = linkTo(methodOn(this.getClass()).retrieveAuthor(authorId));
        bookResource.add(linkToTheAuthorBooks.withRel("the-author-books"));

        return bookResource;
    }


    // create author's book
    @PostMapping("/authors/{authorId}/books") // or @PutMapping
    public ResponseEntity<Object> createAuthorBook(@PathVariable long authorId,
                                                 @Valid @RequestBody Book pBook){

        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if(!optionalAuthor.isPresent()) throw new NotFoundException("Author not found : id - " + authorId);

        Author author = optionalAuthor.get();
        //author.addBook(pBook);
        pBook.addAuthor(author);

        Book vBook = bookRepository.save(pBook);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vBook.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/authors/{authorId}/books/{bookId}")
    public void deleteAuthorLocation(@PathVariable long authorId, @PathVariable long bookId){

        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if(!optionalAuthor.isPresent()) throw new NotFoundException("Author not found : id - " + authorId);

        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(!optionalBook.isPresent()) throw new NotFoundException("Book does not exist: id - " + bookId);

        authorRepositoryCustom.deleteBookFromBooks(authorId, bookId);

    }



}
