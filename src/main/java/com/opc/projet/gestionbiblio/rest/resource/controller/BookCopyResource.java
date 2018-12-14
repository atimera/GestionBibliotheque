package com.opc.projet.gestionbiblio.rest.resource.controller;

import com.opc.projet.gestionbiblio.business.contract.BookCopyRepository;
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
public class BookCopyResource {

    @Autowired
    BookCopyRepository bookCopyRepository;


    // retrieve list of all copies
    @GetMapping("/copies")
    public List<BookCopy> retrieveCopies(){

        return bookCopyRepository.findAll();
    }


    // get a single copy by id
    @GetMapping("/copies/{pId}")
    public Resource<BookCopy> retrieveBookCopy(@PathVariable long pId){

        Optional<BookCopy> optionalBookCopy = bookCopyRepository.findById(pId);
        if(!optionalBookCopy.isPresent()){
            throw new NotFoundException("BookCopy not found : id-"+ pId);
        }


        // HATEOAS
        Resource<BookCopy> copyResource = new Resource<>(optionalBookCopy.get());

        ControllerLinkBuilder linkToCopies = linkTo(methodOn(this.getClass()).retrieveCopies());
        copyResource.add(linkToCopies.withRel("all-copies"));

        return copyResource;
    }


    // create copy
    @PostMapping("/copies") // or @PutMapping
    public ResponseEntity<Object> createBookCopy(@Valid @RequestBody BookCopy pBookCopy){

        BookCopy vBookCopy = bookCopyRepository.save(pBookCopy);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vBookCopy.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/copies/{copyId}")
    public void deleteBookCopy(@PathVariable long copyId){

        Optional<BookCopy> optionalBookCopy = bookCopyRepository.findById(copyId);


        if( !optionalBookCopy.isPresent()) throw new NotFoundException("BookCopy does not exist id-"+ copyId);

        BookCopy vCopy = optionalBookCopy.get();

        // TODO: 15/12/2018 looking for a better way
        vCopy.setBook(null);
        vCopy.setBorrower(null);
        vCopy.setLender(null);
        vCopy = bookCopyRepository.saveAndFlush(vCopy);

        //bookCopyRepository.deleteById(pId);
        bookCopyRepository.delete(vCopy);
        bookCopyRepository.deleteById(copyId);

    }


    // ========================================= //
    // == TODO: 12/12/2018 update not working == //
    // ========================================= //
    // update copy
    @PatchMapping("/copies/{pId}")
    public ResponseEntity<Object> updateBookCopy(
            @Valid @RequestBody BookCopy pBookCopy,
            @PathVariable("pId") long pId){

        Optional<BookCopy> optionalBookCopy = bookCopyRepository.findById(pId);
        if(!optionalBookCopy.isPresent()){
            throw new NotFoundException("BookCopy not found : id - "+ pId);
        }

        BookCopy vBookCopy = bookCopyRepository.save(pBookCopy);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vBookCopy.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
