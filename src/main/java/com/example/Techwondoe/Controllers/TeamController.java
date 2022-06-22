package com.example.Techwondoe.Controllers;

import com.example.Techwondoe.ObjectCreation.TeamObj;
import com.example.Techwondoe.Service.TeamService;
import com.example.Techwondoe.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    TeamService teamService;

    @PostMapping("/create/team/company/{id}")
    public String createCompany(@RequestBody TeamObj teamObj,@PathVariable("id") int id){
            return teamService.saveTeam(teamObj,id);
    }

    @GetMapping("/get/teams")
    public List<Company> getCompany(){
        return teamService.getAllTeams();
    }

}
