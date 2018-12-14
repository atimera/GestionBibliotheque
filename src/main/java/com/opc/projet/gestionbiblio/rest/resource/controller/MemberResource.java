package com.opc.projet.gestionbiblio.rest.resource.controller;

import com.opc.projet.gestionbiblio.business.contract.AddressRepository;
import com.opc.projet.gestionbiblio.business.contract.MemberRepository;
import com.opc.projet.gestionbiblio.business.contract.MemberRepositoryCustom;
import com.opc.projet.gestionbiblio.model.Address;
import com.opc.projet.gestionbiblio.model.BookCopy;
import com.opc.projet.gestionbiblio.model.Library;
import com.opc.projet.gestionbiblio.model.Member;
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
public class MemberResource {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberRepositoryCustom memberRepositoryCustom;

    @Autowired
    AddressRepository addressRepository;



    // retrieve list of all members
    @GetMapping("/members")
    public List<Member> retrieveMembers(){

        return memberRepository.findAll();
    }

    // get a single member by id
    @GetMapping("/members/{pId}")
    public Resource<Member> retrieveMember(@PathVariable long pId){

        Optional<Member> optionalMember = memberRepository.findById(pId);
        if(!optionalMember.isPresent()){
            throw new NotFoundException("Member not found : id - "+ pId);
        }


        // HATEOAS
        Resource<Member> memberResource = new Resource<>(optionalMember.get());

        ControllerLinkBuilder linkToMembers = linkTo(methodOn(this.getClass()).retrieveMembers());
        memberResource.add(linkToMembers.withRel("all-members"));

        ControllerLinkBuilder linkToLocations = linkTo(methodOn(this.getClass()).retrieveMemberLocations(pId));
        memberResource.add(linkToLocations.withRel("member-locations"));

        ControllerLinkBuilder linkToMemberLibraries = linkTo(methodOn(this.getClass()).retrieveMemberLibraries(pId));
        memberResource.add(linkToMemberLibraries.withRel("member-libraries"));

        ControllerLinkBuilder linkToBorrowedCopies = linkTo(methodOn(this.getClass()).retrieveMemberBorrowedCopies(pId));
        memberResource.add(linkToBorrowedCopies.withRel("member-borrowed-copies"));

        return memberResource;
    }

    // create member
    @PostMapping("/members") // or @PutMapping
    public ResponseEntity<Object> createMember(@Valid @RequestBody Member pMember){

        Member vMember = memberRepository.save(pMember);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vMember.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/members/{pId}")
    public void deleteMember(@PathVariable long pId){
        if(memberRepository.findById(pId).isPresent()) throw new NotFoundException("Member does not exist id-"+pId);
        memberRepository.deleteById(pId);

    }


    // ========================================= //
    // == TODO: 12/12/2018 update not working == //
    // ========================================= //
    // update member
    @PatchMapping("/members/{pId}")
    public ResponseEntity<Object> updateMember(
            @Valid @RequestBody Member pMember,
            @PathVariable("pId") long pId){

        Optional<Member> optionalMember = memberRepository.findById(pId);
        if(!optionalMember.isPresent()){
            throw new NotFoundException("Member not found : id - "+ pId);
        }

        Member vMember = memberRepository.save(pMember);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vMember.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }



    // retrieve list of all members
    @GetMapping("/members/{memberId}/locations")
    public List<Address> retrieveMemberLocations(@PathVariable long memberId){

        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalMember.isPresent()){
            throw new NotFoundException("Member not found : id - "+ memberId);
        }

        return memberRepositoryCustom.findMemberAddresses(memberId);

    }

    // get a single member's location by id
    @GetMapping("/members/{memberId}/locations/{addressId}")
    public Resource<Address> retrieveMemberLocation(
            @PathVariable long memberId,
            @PathVariable long addressId){

        // HATEOAS
        Address vAddress = memberRepositoryCustom.findMemberAddressById(memberId, addressId);
        if(vAddress == null) throw new NotFoundException("Address not found : memberId-"+ memberId + " and addressId-" + addressId);

        Resource<Address> addressResource = new Resource<>(vAddress);

        ControllerLinkBuilder linkToMemberLocations = linkTo(methodOn(this.getClass()).retrieveMemberLocations(memberId));
        addressResource.add(linkToMemberLocations.withRel("all-member-locations"));

        return addressResource;
    }

    // create member's location
    @PostMapping("/members/{memberId}/locations") // or @PutMapping
    public ResponseEntity<Object> createMemberLocation(@PathVariable long memberId,
                                                     @Valid @RequestBody Address pAddress){

        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalMember.isPresent()){
            throw new NotFoundException("Member not found : id - "+ memberId);
        }

        // set the relation
        optionalMember.get().addAddress(pAddress);

        Address vAddress = addressRepository.save(pAddress);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{addressId}")
                .buildAndExpand(vAddress.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/members/{memberId}/locations/{addressId}")
    public void deleteMemberLocation(@PathVariable long memberId, @PathVariable long addressId){

        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalMember.isPresent()){
            throw new NotFoundException("Member not found : id - "+ memberId);
        }

        Address vAddress = memberRepositoryCustom.findMemberAddressById(memberId, addressId);
        if(vAddress == null) throw new NotFoundException("Address does not exist: id - " + addressId);

        memberRepositoryCustom.deleteAddressFromMemberAddresses(memberId, addressId);

    }


    // find member's libraries
    @GetMapping("/members/{memberId}/libraries")
    public List<Library> retrieveMemberLibraries(@PathVariable long memberId){

        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalMember.isPresent()) throw new NotFoundException("Member not found id-"+ memberId);

        return optionalMember.get().getLibraries();

    }

    @GetMapping("/members/{memberId}/borrowed-copies")
    public List<BookCopy> retrieveMemberBorrowedCopies(@PathVariable long memberId){

        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if(!optionalMember.isPresent()) throw new NotFoundException("Member not found id-"+ memberId);

        return optionalMember.get().getBorrowedCopies();

    }



}
