package com.opc.projet.gestionbiblio.rest.resource.controller;

import com.opc.projet.gestionbiblio.business.contract.AddressRepository;
import com.opc.projet.gestionbiblio.model.Address;
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
public class AddressResource {

    @Autowired
    AddressRepository addressRepository;


    // retrieve list of all copies
    @GetMapping("/addresses")
    public List<Address> retrieveAddresses(){

        return addressRepository.findAll();
    }


    // get a single address by id
    @GetMapping("/addresses/{pId}")
    public Resource<Address> retrieveAddress(@PathVariable long pId){

        Optional<Address> optionalAddress = addressRepository.findById(pId);
        if(!optionalAddress.isPresent()){
            throw new NotFoundException("Address not found : id-"+ pId);
        }


        // HATEOAS
        Resource<Address> addressResource = new Resource<>(optionalAddress.get());

        ControllerLinkBuilder linkToAddresses = linkTo(methodOn(this.getClass()).retrieveAddresses());
        addressResource.add(linkToAddresses.withRel("all-copies"));

        return addressResource;
    }


    // create address
    @PostMapping("/addresses") // or @PutMapping
    public ResponseEntity<Object> createAddress(@Valid @RequestBody Address pAddress){

        Address vAddress = addressRepository.save(pAddress);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vAddress.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/addresses/{addressId}")
    public void deleteAddress(@PathVariable long addressId){

        Optional<Address> optionalAddress = addressRepository.findById(addressId);


        if( !optionalAddress.isPresent()) throw new NotFoundException("Address does not exist id-"+ addressId);

        Address vAddress = optionalAddress.get();

        addressRepository.deleteById(addressId);

    }


    // ========================================= //
    // == TODO: 12/12/2018 update not working == //
    // ========================================= //
    // update address
    @PatchMapping("/addresses/{pId}")
    public ResponseEntity<Object> updateAddress(
            @Valid @RequestBody Address pAddress,
            @PathVariable("pId") long pId){

        Optional<Address> optionalAddress = addressRepository.findById(pId);
        if(!optionalAddress.isPresent()){
            throw new NotFoundException("Address not found : id - "+ pId);
        }

        Address vAddress = addressRepository.save(pAddress);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vAddress.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
