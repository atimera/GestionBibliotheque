package com.opc.projet.gestionbiblio.rest.resource.controller;

import com.opc.projet.gestionbiblio.business.contract.AddressRepository;
import com.opc.projet.gestionbiblio.business.contract.UserRepository;
import com.opc.projet.gestionbiblio.model.Address;
import com.opc.projet.gestionbiblio.model.User;
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
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;



    // retrieve list of all users
    @GetMapping("/users")
    public List<User> retrieveUsers(){

        return userRepository.findAll();
    }

    // get a single user by id
    @GetMapping("/users/{pId}")
    public Resource<User> retrieveUser(@PathVariable long pId){

        Optional<User> optionalUser = userRepository.findById(pId);
        if(!optionalUser.isPresent()){
            throw new NotFoundException("User not found : id - "+ pId);
        }


        // HATEOAS
        Resource<User> userResource = new Resource<>(optionalUser.get());

        ControllerLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveUsers());
        userResource.add(linkToUsers.withRel("all-users"));

        ControllerLinkBuilder linkToLocations = linkTo(methodOn(this.getClass()).retrieveUserLocations(pId));
        userResource.add(linkToLocations.withRel("user-locations"));

        return userResource;
    }

    // create user
    @PostMapping("/users") // or @PutMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody User pUser){

        User vUser = userRepository.save(pUser);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/users/{pId}")
    public void deleteUser(@PathVariable long pId){
        if(userRepository.findById(pId).isPresent()) throw new NotFoundException("User does not exist id-"+pId);
        userRepository.deleteById(pId);

    }


    // ========================================= //
    // == TODO: 12/12/2018 update not working == //
    // ========================================= //
    // update user
    @PatchMapping("/users/{pId}")
    public ResponseEntity<Object> updateUser(
            @Valid @RequestBody User pUser,
            @PathVariable("pId") long pId){

        Optional<User> optionalUser = userRepository.findById(pId);
        if(!optionalUser.isPresent()){
            throw new NotFoundException("User not found : id - "+ pId);
        }

        User vUser = userRepository.save(pUser);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }



    // retrieve list of all users
    @GetMapping("/users/{userId}/locations")
    public List<Address> retrieveUserLocations(@PathVariable long userId){

        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new NotFoundException("User not found : id - "+ userId);
        }

        User vUser = optionalUser.get();

        return vUser.getLocations();

    }

    // get a single user's location by id
    @GetMapping("/users/{userId}/locations/{addressId}")
    public Resource<Address> retrieveUserLocation(
            @PathVariable long userId,
            @PathVariable long addressId){

        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new NotFoundException("User not found : id - "+ userId);
        }

        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if(!optionalAddress.isPresent()) throw new NotFoundException("Address not found : id - " + addressId);

        // HATEOAS
        Resource<Address> addressResource = new Resource<>(optionalAddress.get());

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveUserLocations(userId));
        addressResource.add(linkTo.withRel("all-user-locations"));

        return addressResource;
    }

    // create user's location
    @PostMapping("/users/{userId}/locations") // or @PutMapping
    public ResponseEntity<Object> createUserLocation(@PathVariable long userId,
                                                     @Valid @RequestBody Address pAddress){

        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new NotFoundException("User not found : id - "+ userId);
        }

        // set the relation
        optionalUser.get().addAddress(pAddress);

        Address vAddress = addressRepository.save(pAddress);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vAddress.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{userId}/locations/{addressId}")
    public void deleteUserLocation(@PathVariable long userId, @PathVariable long addressId){

        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new NotFoundException("User not found : id - "+ userId);
        }

        addressRepository.deleteById(addressId);

    }





}
