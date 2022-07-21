package com.example.CompanyDetails.Service;

import com.example.CompanyDetails.Error.NotFoundExecption;
import com.example.CompanyDetails.Repositories.CompanyRepo;
import com.example.CompanyDetails.Responses.CompanyResponse;
import com.example.CompanyDetails.models.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
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
