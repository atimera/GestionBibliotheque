package com.opc.projet.gestionbiblio.controller;

import com.opc.projet.gestionbiblio.model.Address;
import com.opc.projet.gestionbiblio.service.contract.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping({"/", "/list"})
    public String getAddresses(Model pModel){
        pModel.addAttribute("addresses", addressService.getAll());
        return "address/list";
    }

    @RequestMapping("/{id}")
    public String getAddress(@PathVariable int id, Model pModel){
        Address vAddress = addressService.getById(id);
        if(vAddress == null){
            return "redirect:/address/list";
        }
        pModel.addAttribute("address", vAddress);
        return "address/details";
    }

    @RequestMapping("/new")
    public String newAddress(Model pModel){
        pModel.addAttribute("address", new Address());
        return "address/form";
    }

    @RequestMapping("/edit/{id}")
    public String editAddress(@PathVariable int id, Model pModel){
        Address vAddress = addressService.getById(id);
        if(vAddress == null){
            return "redirect:/address/list";
        }
        pModel.addAttribute("address", vAddress);

        return "address/form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteAddress(@PathVariable int id){
        addressService.deleteById(id);
        return "redirect:/addresses/list";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String saveOrUpdateAddress(@Valid @ModelAttribute("address") Address pAddress,
                                      BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "address/form";
        }
        Address address = addressService.save(pAddress);
        System.out.println("\n\n\n" + pAddress + "\n\n\n");
        return "redirect:/addresses/"+ address.getId();
    }

}
