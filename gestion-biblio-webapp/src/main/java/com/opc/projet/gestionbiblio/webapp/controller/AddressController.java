//package com.opc.projet.gestionbiblio.webapp.controller;
//
//import com.opc.projet.gestionbiblio.webapp.entity.Address;
//import com.opc.projet.gestionbiblio.webapp.service.contract.AddressService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//@RequestMapping("/address")
//public class AddressController {
//
//
//    @Autowired
//    private AddressService addressService;
//
//    @GetMapping("/list")
//    public String listAddresses(Model theModel){
//
//
//        List<Address> theAddresses = addressService.getAddresses();
//
//        // add addresses the spring mvc model
//        theModel.addAttribute("addresses", theAddresses);
//
//        return "list-addresses";
//    }
//
//    @GetMapping("/showForm")
//    public String showForm(Model theModel){
//
//        theModel.addAttribute("address", new Address());
//
//        return "address-form";
//    }
//
//    @GetMapping("showFormForAdd")
//    public String showFormForAdd(Model theModel){
//
//        theModel.addAttribute("address", new Address());
//
//        return "address-form";
//    }
//
//    @PostMapping("/saveAddress")
//    public String saveAddress(@Valid @ModelAttribute("address") Address theAddress,
//                              BindingResult bindingResult){
//
//        // TODO: 25/11/2018 Form Validation
//
//        addressService.saveAddress(theAddress);
//
//        return "redirect:/address/list";
//    }
//
//    @RequestMapping("/delete{id}")
//    public String delete(){
//
//        // TODO: 25/11/2018
//
//        return "list-addresses";
//    }
//
//
//}
