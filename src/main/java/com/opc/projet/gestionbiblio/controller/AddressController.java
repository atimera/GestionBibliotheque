package com.opc.projet.gestionbiblio.controller;

import com.opc.projet.gestionbiblio.model.Address;
import com.opc.projet.gestionbiblio.service.contract.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/address")
public class AddressController {


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
        addressService.delete(id);
        return "redirect:/address/list";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String saveOrUpdateAddress(@ModelAttribute("address") Address pAddress){
        Address address = addressService.saveOrUpdate(pAddress);
        System.out.println("\n\n\n" + pAddress + "\n\n\n");
        return "redirect:/address/"+ address.getId();
    }

}
