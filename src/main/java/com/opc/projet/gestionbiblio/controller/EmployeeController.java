package com.opc.projet.gestionbiblio.controller;

import com.opc.projet.gestionbiblio.model.Employee;
import com.opc.projet.gestionbiblio.service.contract.EmployeeService;
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
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping({"", "/", "/list"})
    public String getEmployees(Model pModel){
        pModel.addAttribute("employees", employeeService.getAll());
        return "employees/list";
    }

    @RequestMapping("/{id}")
    public String getEmployee(@PathVariable int id, Model pModel){
        Employee vEmployee = employeeService.getById(id);
        if(vEmployee == null){
            return "redirect:/employees/list";
        }
        pModel.addAttribute("employee", vEmployee);
        return "employees/details";
    }

    @RequestMapping("/new")
    public String newEmployee(Model pModel){
        pModel.addAttribute("employee", new Employee());
        return "employees/form";
    }

    @RequestMapping("/edit/{id}")
    public String editEmployee(@PathVariable int id, Model pModel){
        Employee vEmployee = employeeService.getById(id);
        if(vEmployee == null){
            return "redirect:/employees/list";
        }
        pModel.addAttribute("employee", vEmployee);

        return "employees/form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String saveOrUpdateEmployee(@Valid @ModelAttribute("employee") Employee pEmployee,
                                      BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "employees/form";
        }
        Employee employee = employeeService.save(pEmployee);
        return "redirect:/employees/"+ employee.getId();
    }

}
