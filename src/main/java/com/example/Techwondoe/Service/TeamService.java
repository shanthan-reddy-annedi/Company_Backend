package com.example.Techwondoe.Service;

import com.example.Techwondoe.ObjectCreation.TeamObj;
import com.example.Techwondoe.Repositories.CompanyRepo;
import com.example.Techwondoe.Repositories.TeamRepo;
import com.example.Techwondoe.models.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepo teamRepo;
    private final CompanyRepo companyRepo;

    public String saveTeam(TeamObj teamObj, int id){
        Company company = companyRepo.findById(id).orElse(null);
        if(company != null) {
            teamRepo.save(teamObj.toTeam(company));
            return "Saved Successfully";
        }
        else
            return "Company Doesn't exist";
    }

    public List<Company> getAllTeams(){
        return companyRepo.findAll();
    }
}
