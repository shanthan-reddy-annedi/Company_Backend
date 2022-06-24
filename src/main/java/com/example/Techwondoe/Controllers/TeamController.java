package com.example.Techwondoe.Controllers;

import com.example.Techwondoe.ObjectCreation.TeamObj;
import com.example.Techwondoe.Service.TeamService;
import com.example.Techwondoe.models.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping("/api/create/team/company/{id}")
    public String createCompany(@RequestBody @Valid TeamObj teamObj, @PathVariable("id") int id){
            return teamService.saveTeam(teamObj,id);
    }

    @GetMapping("/api/get/teams")
    public List<Company> getCompany(){
        return teamService.getAllTeams();
    }

}
