package com.opc.projet.gestionbiblio.rest.resource.controller;

import com.opc.projet.gestionbiblio.business.contract.AddressRepository;
import com.opc.projet.gestionbiblio.business.contract.EmployeeRepository;
import com.opc.projet.gestionbiblio.business.contract.EmployeeRepositoryCustom;
import com.opc.projet.gestionbiblio.model.Address;
import com.opc.projet.gestionbiblio.model.BookCopy;
import com.opc.projet.gestionbiblio.model.Library;
import com.opc.projet.gestionbiblio.model.Employee;
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
public class EmployeeResource {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeRepositoryCustom employeeRepositoryCustom;

    @Autowired
    AddressRepository addressRepository;



    // retrieve list of all employees
    @GetMapping("/employees")
    public List<Employee> retrieveEmployees(){

        return employeeRepository.findAll();
    }

    // get a single employee by id
    @GetMapping("/employees/{pId}")
    public Resource<Employee> retrieveEmployee(@PathVariable long pId){

        Optional<Employee> optionalEmployee = employeeRepository.findById(pId);
        if(!optionalEmployee.isPresent()){
            throw new NotFoundException("Employee not found : id - "+ pId);
        }


        // HATEOAS
        Resource<Employee> employeeResource = new Resource<>(optionalEmployee.get());

        ControllerLinkBuilder linkToEmployees = linkTo(methodOn(this.getClass()).retrieveEmployees());
        employeeResource.add(linkToEmployees.withRel("all-employees"));

        ControllerLinkBuilder linkToLocations = linkTo(methodOn(this.getClass()).retrieveEmployeeLocations(pId));
        employeeResource.add(linkToLocations.withRel("employee-locations"));

        ControllerLinkBuilder linkToEmployeeLibraries = linkTo(methodOn(this.getClass()).retrieveEmployeeWorkplace(pId));
        employeeResource.add(linkToEmployeeLibraries.withRel("employee-workplace"));

        ControllerLinkBuilder linkToBorrowedCopies = linkTo(methodOn(this.getClass()).retrieveEmployeeLendedCopies(pId));
        employeeResource.add(linkToBorrowedCopies.withRel("employee-lended-copies"));

        return employeeResource;
    }

    // create employee
    @PostMapping("/employees") // or @PutMapping
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee pEmployee){

        Employee vEmployee = employeeRepository.save(pEmployee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vEmployee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/employees/{pId}")
    public void deleteEmployee(@PathVariable long pId){
        if(employeeRepository.findById(pId).isPresent()) throw new NotFoundException("Employee does not exist id-"+pId);
        employeeRepository.deleteById(pId);

    }


    // ========================================= //
    // == TODO: 12/12/2018 update not working == //
    // ========================================= //
    // update employee
    @PatchMapping("/employees/{pId}")
    public ResponseEntity<Object> updateEmployee(
            @Valid @RequestBody Employee pEmployee,
            @PathVariable("pId") long pId){

        Optional<Employee> optionalEmployee = employeeRepository.findById(pId);
        if(!optionalEmployee.isPresent()){
            throw new NotFoundException("Employee not found : id - "+ pId);
        }

        Employee vEmployee = employeeRepository.save(pEmployee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vEmployee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }



    // retrieve list of all employees
    @GetMapping("/employees/{employeeId}/locations")
    public List<Address> retrieveEmployeeLocations(@PathVariable long employeeId){

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(!optionalEmployee.isPresent()){
            throw new NotFoundException("Employee not found : id - "+ employeeId);
        }

        return employeeRepositoryCustom.findEmployeeAddresses(employeeId);

    }

    // get a single employee's location by id
    @GetMapping("/employees/{employeeId}/locations/{addressId}")
    public Resource<Address> retrieveEmployeeLocation(
            @PathVariable long employeeId,
            @PathVariable long addressId){

        // HATEOAS
        Address vAddress = employeeRepositoryCustom.findEmployeeAddressById(employeeId, addressId);
        if(vAddress == null) throw new NotFoundException("Address not found : employeeId-"+ employeeId + " and addressId-" + addressId);

        Resource<Address> addressResource = new Resource<>(vAddress);

        ControllerLinkBuilder linkToEmployeeLocations = linkTo(methodOn(this.getClass()).retrieveEmployeeLocations(employeeId));
        addressResource.add(linkToEmployeeLocations.withRel("all-employee-locations"));

        return addressResource;
    }

    // create employee's location
    @PostMapping("/employees/{employeeId}/locations") // or @PutMapping
    public ResponseEntity<Object> createEmployeeLocation(@PathVariable long employeeId,
                                                     @Valid @RequestBody Address pAddress){

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(!optionalEmployee.isPresent()){
            throw new NotFoundException("Employee not found : id - "+ employeeId);
        }

        // set the relation
        optionalEmployee.get().addAddress(pAddress);

        Address vAddress = addressRepository.save(pAddress);

        URI location;
        location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vAddress.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employees/{employeeId}/locations/{addressId}")
    public void deleteEmployeeLocation(@PathVariable long employeeId, @PathVariable long addressId){

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(!optionalEmployee.isPresent()){
            throw new NotFoundException("Employee not found : id - "+ employeeId);
        }

        Address vAddress = employeeRepositoryCustom.findEmployeeAddressById(employeeId, addressId);
        if(vAddress == null) throw new NotFoundException("Address does not exist: id - " + addressId);

        employeeRepositoryCustom.deleteAddressFromEmployeeAddresses(employeeId, addressId);

    }


    // find employee's libraries
    @GetMapping("/employees/{employeeId}/workplace")
    public Library retrieveEmployeeWorkplace(@PathVariable long employeeId){

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(!optionalEmployee.isPresent()) throw new NotFoundException("Employee not found id-"+ employeeId);

        return optionalEmployee.get().getLibrary();

    }

    @GetMapping("/employees/{employeeId}/lended-copies")
    public List<BookCopy> retrieveEmployeeLendedCopies(@PathVariable long employeeId){

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if(!optionalEmployee.isPresent()) throw new NotFoundException("Employee not found id-"+ employeeId);

        return optionalEmployee.get().getLendedCopies();

    }



}
