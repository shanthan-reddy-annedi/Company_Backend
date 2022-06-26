package com.example.CompanyDetails.Service;

import com.example.CompanyDetails.ObjectCreation.TeamObj;
import com.example.CompanyDetails.Repositories.CompanyRepo;
import com.example.CompanyDetails.Repositories.TeamRepo;
import com.example.CompanyDetails.models.Company;
import com.example.CompanyDetails.models.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {TeamService.class})
@ExtendWith(MockitoExtension.class)
class TeamServiceTest {

    @Mock
    private CompanyRepo companyRepo;

    @Mock
    private TeamRepo teamRepo;


    private TeamService teamService;

    @BeforeEach
    void setUp(){
        teamService = new TeamService(teamRepo,companyRepo);
    }


    @Test
    void testSaveTeam() {
        Company company = new Company();
        company.setCompanyAddress("42 Main St");
        company.setCompanyCEO("Company CEO");
        company.setCompanyName("Company Name");
        company.setInceptionDate("2020-03-01");
        company.setTeam(new ArrayList<>());
        company.setUUID(1);

        Team team = new Team();
        team.setCompany(company);
        team.setLeadName("Lead Name");
        team.setUUID(1);
        when(teamRepo.save((Team) any())).thenReturn(team);

        Company company1 = new Company();
        company1.setCompanyAddress("42 Main St");
        company1.setCompanyCEO("Company CEO");
        company1.setCompanyName("Company Name");
        company1.setInceptionDate("2020-03-01");
        company1.setTeam(new ArrayList<>());
        company1.setUUID(1);
        Optional<Company> ofResult = Optional.of(company1);
        when(companyRepo.findById((Integer) any())).thenReturn(ofResult);
        assertEquals("Saved Successfully", teamService.saveTeam(new TeamObj("Lead Name"), 1));
        verify(teamRepo).save((Team) any());
        verify(companyRepo).findById((Integer) any());
    }


    @Test
    void testSaveTeam3() {
        Company company = new Company();
        company.setCompanyAddress("42 Main St");
        company.setCompanyCEO("Company CEO");
        company.setCompanyName("Company Name");
        company.setInceptionDate("2020-03-01");
        company.setTeam(new ArrayList<>());
        company.setUUID(1);

        Team team = new Team();
        team.setCompany(company);
        team.setLeadName("Lead Name");
        team.setUUID(1);
        when(companyRepo.findById((Integer) any())).thenReturn(Optional.empty());
        assertEquals("Company Doesn't exist", teamService.saveTeam(new TeamObj("Lead Name"), 1));
        verify(companyRepo).findById((Integer) any());
    }



    @Test
    void testSaveTeam5() {
        Company company = new Company();
        company.setCompanyAddress("42 Main St");
        company.setCompanyCEO("Company CEO");
        company.setCompanyName("Company Name");
        company.setInceptionDate("2020-03-01");
        company.setTeam(new ArrayList<>());
        company.setUUID(1);

        Team team = new Team();
        team.setCompany(company);
        team.setLeadName("Lead Name");
        team.setUUID(1);
        when(teamRepo.save((Team) any())).thenReturn(team);

        Company company1 = new Company();
        company1.setCompanyAddress("42 Main St");
        company1.setCompanyCEO("Company CEO");
        company1.setCompanyName("Company Name");
        company1.setInceptionDate("2020-03-01");
        company1.setTeam(new ArrayList<>());
        company1.setUUID(1);
        Optional<Company> ofResult = Optional.of(company1);
        when(companyRepo.findById((Integer) any())).thenReturn(ofResult);

        Company company2 = new Company();
        company2.setCompanyAddress("42 Main St");
        company2.setCompanyCEO("Company CEO");
        company2.setCompanyName("Company Name");
        company2.setInceptionDate("2020-03-01");
        company2.setTeam(new ArrayList<>());
        company2.setUUID(1);

        Team team1 = new Team();
        team1.setCompany(company2);
        team1.setLeadName("Lead Name");
        team1.setUUID(1);
        TeamObj teamObj = mock(TeamObj.class);
        when(teamObj.toTeam((Company) any())).thenReturn(team1);
        assertEquals("Saved Successfully", teamService.saveTeam(teamObj, 1));
        verify(teamRepo).save((Team) any());
        verify(companyRepo).findById((Integer) any());
        verify(teamObj).toTeam((Company) any());
    }

    @Test
    void testGetAllTeams() {
        ArrayList<Company> companyList = new ArrayList<>();
        when(companyRepo.findAll()).thenReturn(companyList);
        List<Company> actualAllTeams = teamService.getAllTeams();
        assertSame(companyList, actualAllTeams);
        assertTrue(actualAllTeams.isEmpty());
        verify(companyRepo).findAll();
    }

}