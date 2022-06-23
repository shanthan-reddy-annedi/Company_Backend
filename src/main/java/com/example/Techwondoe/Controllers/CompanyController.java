package com.example.Techwondoe.Controllers;

import com.example.Techwondoe.ObjectCreation.ComapnyObj;
import com.example.Techwondoe.Responses.CompanyResponse;
import com.example.Techwondoe.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/company/create")
    public void createCompany(@RequestBody ComapnyObj comapnyObj){
        companyService.saveCompany(comapnyObj.toCompany());
    }

    @GetMapping("/get/company/byid/{id}")
    public CompanyResponse getCompany(@PathVariable("id") int id){
        return companyService.getCompanyWithTeam(id).toCompanyResponse();
    }

    @GetMapping("/get/company/byname/{name}")
    public CompanyResponse getCompanyByName(@PathVariable("name") String name){
        return companyService.getCompanyByName(name);
    }

}
