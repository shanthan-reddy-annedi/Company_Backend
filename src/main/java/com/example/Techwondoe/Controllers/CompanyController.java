package com.example.Techwondoe.Controllers;

import com.example.Techwondoe.ObjectCreation.ComapnyObj;
import com.example.Techwondoe.Service.CompanyService;
import com.example.Techwondoe.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/company/create")
    public void createCompany(@RequestBody ComapnyObj comapnyObj){
//        System.out.println("comapnyObj = " + comapnyObj);
        companyService.saveCompany(comapnyObj.toCompany());
    }

    @GetMapping("/company/id/{id}")
    public Company getCompany(@PathVariable("id") int id){
        return companyService.getCompanyWithTeam(id);
    }

}
