package com.opc.projet.gestionbiblio.webapp.controller;

import com.opc.projet.gestionbiblio.webapp.dao.contract.AddressDao;
import com.opc.projet.gestionbiblio.webapp.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {

    // need to inject the Address Dao
    @Autowired // will look for AddressDaoImpl
    private AddressDao addressDao;

    @RequestMapping("/list")
    public String listAddresses(Model theModel){

        // get addresses from the dao
        List<Address> theAddresses = addressDao.getAddresses();

        // add addresses the spring mvc model
        theModel.addAttribute("addresses", theAddresses);

        return "list-addresses";
    }

    @RequestMapping("showForm")
    public String showForm(Model theModel){

        theModel.addAttribute("address", new Address());

        return "address-form";
    }

    @RequestMapping("processForm")
    public String processForm(@Valid @ModelAttribute("address") Address theAddress,
                              BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "address-form";
        }else {
            return "address-confirmation";
        }
    }


}
