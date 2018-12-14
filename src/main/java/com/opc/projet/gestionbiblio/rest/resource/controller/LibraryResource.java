package com.opc.projet.gestionbiblio.rest.resource.controller;

import com.opc.projet.gestionbiblio.business.contract.AddressRepository;
import com.opc.projet.gestionbiblio.business.contract.LibraryRepository;
import com.opc.projet.gestionbiblio.model.*;
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
public class LibraryResource {

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    AddressRepository addressRepository;


    // retrieve list of all libraries
    @GetMapping("/libraries")
    public List<Library> retrieveLibraries(){

        return libraryRepository.findAll();
    }


    // get a single library by id
    @GetMapping("/libraries/{pId}")
    public Resource<Library> retrieveLibrary(@PathVariable long pId){

        Optional<Library> optionalLibrary = libraryRepository.findById(pId);
        if(!optionalLibrary.isPresent()){
            throw new NotFoundException("Library not found : id - "+ pId);
        }


        // HATEOAS
        Resource<Library> libraryResource = new Resource<>(optionalLibrary.get());

        ControllerLinkBuilder linkToLibraries = linkTo(methodOn(this.getClass()).retrieveLibraries());
        libraryResource.add(linkToLibraries.withRel("all-libraries"));

        ControllerLinkBuilder linkToLocations = linkTo(methodOn(this.getClass()).retrieveLibraryLocation(pId));
        libraryResource.add(linkToLocations.withRel("library-location"));

        ControllerLinkBuilder linkToEmployees = linkTo(methodOn(this.getClass()).retrieveLibraryEmployees(pId));
        libraryResource.add(linkToEmployees.withRel("library-employees"));

        ControllerLinkBuilder linkToBooks = linkTo(methodOn(this.getClass()).retrieveLibraryBooks(pId));
        libraryResource.add(linkToBooks.withRel("library-books"));

        ControllerLinkBuilder linkToMembers = linkTo(methodOn(this.getClass()).retrieveLibraryMembers(pId));
        libraryResource.add(linkToMembers.withRel("library-members"));

        return libraryResource;
    }


    // create library
    @PostMapping("/libraries") // or @PutMapping
    public ResponseEntity<Object> createLibrary(@Valid @RequestBody Library pLibrary){

        Library vLibrary = libraryRepository.save(pLibrary);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vLibrary.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/libraries/{pId}")
    public void deleteLibrary(@PathVariable long pId){
        if( !libraryRepository.findById(pId).isPresent()) throw new NotFoundException("Library does not exist id-"+pId);
        libraryRepository.deleteById(pId);

    }


    // ========================================= //
    // == TODO: 12/12/2018 update not working == //
    // ========================================= //
    // update library
    @PatchMapping("/libraries/{pId}")
    public ResponseEntity<Object> updateLibrary(
            @Valid @RequestBody Library pLibrary,
            @PathVariable("pId") long pId){

        Optional<Library> optionalLibrary = libraryRepository.findById(pId);
        if(!optionalLibrary.isPresent()){
            throw new NotFoundException("Library not found : id - "+ pId);
        }

        Library vLibrary = libraryRepository.save(pLibrary);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vLibrary.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    // retrieve list of all libraries
    @GetMapping("/libraries/{libraryId}/locations")
    public Address retrieveLibraryLocation(@PathVariable long libraryId){

        Optional<Library> optionalLibrary = libraryRepository.findById(libraryId);
        if(!optionalLibrary.isPresent()){
            throw new NotFoundException("Library not found : id - "+ libraryId);
        }

        Library vLibrary = optionalLibrary.get();

        return vLibrary.getLocation();

    }


    // get a single library's location by id
    @GetMapping("/libraries/{libraryId}/locations/{addressId}")
    public Resource<Address> retrieveLibraryLocation(
            @PathVariable long libraryId,
            @PathVariable long addressId){

        Optional<Library> optionalLibrary = libraryRepository.findById(libraryId);
        if(!optionalLibrary.isPresent()){
            throw new NotFoundException("Library not found : id - "+ libraryId);
        }

        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if(!optionalAddress.isPresent()) throw new NotFoundException("Address not found : id - " + addressId);

        // HATEOAS
        Resource<Address> addressResource = new Resource<>(optionalAddress.get());

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveLibraryLocation(libraryId));
        addressResource.add(linkTo.withRel("library-location"));

        return addressResource;
    }


    // create library's location
    @PostMapping("/libraries/{libraryId}/locations") // or @PutMapping
    public ResponseEntity<Object> createLibraryLocation(@PathVariable long libraryId,
                                                        @Valid @RequestBody Address pAddress){

        Optional<Library> optionalLibrary = libraryRepository.findById(libraryId);
        if(!optionalLibrary.isPresent()) throw new NotFoundException("Library not found : id - " + libraryId);

        Address vAddress = addressRepository.save(pAddress);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vAddress.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    // update library's location
    @PatchMapping("/libraries/{libraryId}/locations") // or @PutMapping
    public ResponseEntity<Object> updateLibraryLocation(@PathVariable long libraryId,
                                                        @Valid @RequestBody Address pAddress){

        Optional<Library> optionalLibrary = libraryRepository.findById(libraryId);
        if(!optionalLibrary.isPresent()) throw new NotFoundException("Library not found : id - " + libraryId);

        // check if it has an address
        Library library = optionalLibrary.get();
        Address vAddress = null;
        if(library.getLocation() == null){
            // set the relation
            optionalLibrary.get().setLocation(pAddress);
            vAddress = addressRepository.save(pAddress);
        }else{
            pAddress.setId(library.getLocation().getId());
            vAddress = addressRepository.save(pAddress);
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vAddress.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/libraries/{libraryId}/locations/{addressId}")
    public void deleteLibraryLocation(@PathVariable long libraryId, @PathVariable long addressId){

        Optional<Library> optionalLibrary = libraryRepository.findById(libraryId);
        if(!optionalLibrary.isPresent()) throw new NotFoundException("Library not found : id - "+ libraryId);

        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if(!optionalAddress.isPresent()) throw new NotFoundException("Address does not exist : id - "+ addressId);

        optionalLibrary.get().setLocation(null);

        addressRepository.deleteById(addressId);
    }


    // retrieve list of library's employees
    @GetMapping("/libraries/{libraryId}/employees")
    public List<Employee> retrieveLibraryEmployees(@PathVariable long libraryId){
        Optional<Library> optionalLibrary = libraryRepository.findById(libraryId);
        if (!optionalLibrary.isPresent()) throw new NotFoundException("Library not found id-"+ libraryId);

        return optionalLibrary.get().getEmployees();
    }


    // retrieve list of library's books
    @GetMapping("/libraries/{libraryId}/books")
    public List<Book> retrieveLibraryBooks(@PathVariable long libraryId){
        Optional<Library> optionalLibrary = libraryRepository.findById(libraryId);
        if (!optionalLibrary.isPresent()) throw new NotFoundException("Library not found id-"+ libraryId);

        return optionalLibrary.get().getBooks();
    }


    // retrieve list of library's books
    @GetMapping("/libraries/{libraryId}/members")
    public List<Member> retrieveLibraryMembers(@PathVariable long libraryId){
        Optional<Library> optionalLibrary = libraryRepository.findById(libraryId);
        if (!optionalLibrary.isPresent()) throw new NotFoundException("Library not found id-"+ libraryId);

        return optionalLibrary.get().getMembers();
    }




}
