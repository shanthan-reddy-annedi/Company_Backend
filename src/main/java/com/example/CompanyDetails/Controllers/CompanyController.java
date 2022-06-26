package com.example.CompanyDetails.Controllers;

import com.example.CompanyDetails.ObjectCreation.ComapnyObj;
import com.example.CompanyDetails.Responses.CompanyResponse;
import com.example.CompanyDetails.Service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/api/company/create")
    public void createCompany(@RequestBody @Valid ComapnyObj comapnyObj){
        companyService.saveCompany(comapnyObj.toCompany());
    }

    @GetMapping("/api/get/company/byid/{id}")
    public CompanyResponse getCompanyById(@PathVariable("id") int id){
        return companyService.getCompanyWithTeam(id).toCompanyResponse();
    }

    @GetMapping("/api/get/company/byname/{name}")
    public CompanyResponse getCompanyByName(@PathVariable("name") String name){
        return companyService.getCompanyByName(name);
    }

}
