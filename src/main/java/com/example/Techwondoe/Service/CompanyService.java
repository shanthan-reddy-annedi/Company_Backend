package com.example.Techwondoe.Service;

import com.example.Techwondoe.Repositories.CompanyRepo;
import com.example.Techwondoe.Responses.CompanyResponse;
import com.example.Techwondoe.models.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private CompanyRepo companyRepo;

    public CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public void saveCompany(Company company){
        companyRepo.save(company);
    }

    public Company getCompanyWithTeam(int id){
        return companyRepo.findById(id).orElse(null);
    }

    public CompanyResponse getCompanyByName(String name){
        try{
            return companyRepo.getComapanyByName(name).toCompanyResponse();
        }catch (Exception e){
            return null;
        }

    }

}
