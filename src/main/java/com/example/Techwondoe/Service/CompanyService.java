package com.example.Techwondoe.Service;

import com.example.Techwondoe.Error.NotFoundExecption;
import com.example.Techwondoe.Repositories.CompanyRepo;
import com.example.Techwondoe.Responses.CompanyResponse;
import com.example.Techwondoe.models.Company;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import javax.validation.constraints.Null;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepo companyRepo;

    public void saveCompany(Company company){
        companyRepo.save(company);
    }

    public Company getCompanyWithTeam(int id){
        return companyRepo.findById(id).orElse(null);
    }

    public CompanyResponse getCompanyByName(String name){
        return companyRepo.getComapanyByName(name).orElseThrow(()-> new NotFoundExecption("Company Not Found")).toCompanyResponse();

    }

}
