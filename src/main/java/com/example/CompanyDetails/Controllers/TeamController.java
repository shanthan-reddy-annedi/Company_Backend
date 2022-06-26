package com.example.CompanyDetails.Controllers;

import com.example.CompanyDetails.ObjectCreation.TeamObj;
import com.example.CompanyDetails.Service.TeamService;
import com.example.CompanyDetails.models.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
    @PostMapping("/api/create/team/company/{id}")
    public String createTeam(@RequestBody @Valid TeamObj teamObj, @PathVariable("id") int id){
            return teamService.saveTeam(teamObj,id);
    }
    @GetMapping("/api/get/teams")
    public List<Company> getCompany(){
            return teamService.getAllTeams();
    }

}
