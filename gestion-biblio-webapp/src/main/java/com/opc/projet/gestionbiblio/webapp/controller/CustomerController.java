package com.opc.projet.gestionbiblio.webapp.controller;

import com.opc.projet.gestionbiblio.webapp.dao.contract.MemberDao;
import com.opc.projet.gestionbiblio.webapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {



    @Autowired
    private MemberDao customerDao;

    @RequestMapping("/list")
    public String listCustomer(Model theModel){

        // get customers from the dao
        List<Customer> theCustomers = customerDao.getCustomers();

        // add customers the spring mvc model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @RequestMapping("showForm")
    public String showForm(Model theModel){

        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @RequestMapping("processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "customer-form";
        }else {
            return "customer-confirmation";
        }
    }

	
}
