package com.example.Techwondoe.Service;

import com.example.Techwondoe.ObjectCreation.TeamObj;
import com.example.Techwondoe.Repositories.CompanyRepo;
import com.example.Techwondoe.Repositories.TeamRepo;
import com.example.Techwondoe.models.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private TeamRepo teamRepo;
    private CompanyRepo companyRepo;

    public TeamService(TeamRepo teamRepo, CompanyRepo companyRepo) {
        this.teamRepo = teamRepo;
        this.companyRepo = companyRepo;
    }

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
