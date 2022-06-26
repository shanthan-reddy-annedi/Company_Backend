package com.example.CompanyDetails.Service;

import com.example.CompanyDetails.ObjectCreation.TeamObj;
import com.example.CompanyDetails.Repositories.CompanyRepo;
import com.example.CompanyDetails.Repositories.TeamRepo;
import com.example.CompanyDetails.models.Company;
import com.example.CompanyDetails.models.Team;
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
            Team team = teamObj.toTeam(company);
            teamRepo.save(team);
            return "Saved Successfully";
        }
        else
            return "Company Doesn't exist";
    }

    public List<Company> getAllTeams(){
        return companyRepo.findAll();
    }
}
