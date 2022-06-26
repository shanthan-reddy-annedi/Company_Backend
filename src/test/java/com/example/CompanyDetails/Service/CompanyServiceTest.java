package com.example.CompanyDetails.Service;

import com.example.CompanyDetails.Error.NotFoundExecption;
import com.example.CompanyDetails.Repositories.CompanyRepo;
import com.example.CompanyDetails.Responses.CompanyResponse;
import com.example.CompanyDetails.models.Company;
import com.example.CompanyDetails.models.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {CompanyService.class})
@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

    @Mock
    private CompanyRepo companyRepo;

    private CompanyService companyService;

    @BeforeEach
    void setUp(){
        companyService = new CompanyService(companyRepo);
    }

    @Test
    void testSaveCompany() {
        Company company = new Company();
        company.setCompanyAddress("42 Main St");
        company.setCompanyCEO("Company CEO");
        company.setCompanyName("Company Name");
        company.setInceptionDate("2020-03-01");
        ArrayList<Team> teamList = new ArrayList<>();
        company.setTeam(teamList);
        company.setUUID(1);
        when(companyRepo.save((Company) any())).thenReturn(company);

        Company company1 = new Company();
        company1.setCompanyAddress("42 Main St");
        company1.setCompanyCEO("Company CEO");
        company1.setCompanyName("Company Name");
        company1.setInceptionDate("2020-03-01");
        company1.setTeam(new ArrayList<>());
        company1.setUUID(1);
        companyService.saveCompany(company1);
        verify(companyRepo).save((Company) any());
        assertEquals("42 Main St", company1.getCompanyAddress());
        assertEquals(1, company1.getUUID());
        assertEquals(teamList, company1.getTeam());
        assertEquals("2020-03-01", company1.getInceptionDate());
        assertEquals("Company Name", company1.getCompanyName());
        assertEquals("Company CEO", company1.getCompanyCEO());
    }


    @Test
    void testSaveCompany2() {
        when(companyRepo.save((Company) any())).thenThrow(new NotFoundExecption("Not all who wander are lost"));

        Company company = new Company();
        company.setCompanyAddress("42 Main St");
        company.setCompanyCEO("Company CEO");
        company.setCompanyName("Company Name");
        company.setInceptionDate("2020-03-01");
        company.setTeam(new ArrayList<>());
        company.setUUID(1);
        assertThrows(NotFoundExecption.class, () -> companyService.saveCompany(company));
        verify(companyRepo).save((Company) any());
    }


    @Test
    void testGetCompanyWithTeam() {
        Company company = new Company();
        company.setCompanyAddress("42 Main St");
        company.setCompanyCEO("Company CEO");
        company.setCompanyName("Company Name");
        company.setInceptionDate("2020-03-01");
        company.setTeam(new ArrayList<>());
        company.setUUID(1);
        Optional<Company> ofResult = Optional.of(company);
        when(companyRepo.findById((Integer) any())).thenReturn(ofResult);
        assertSame(company, companyService.getCompanyWithTeam(1));
        verify(companyRepo).findById((Integer) any());
    }

    @Test
    void testGetCompanyWithTeam2() {
        when(companyRepo.findById((Integer) any())).thenThrow(new NotFoundExecption("Not all who wander are lost"));
        assertThrows(NotFoundExecption.class, () -> companyService.getCompanyWithTeam(1));
        verify(companyRepo).findById((Integer) any());
    }

    @Test
    void testGetCompanyByName() {
        Company company = new Company();
        company.setCompanyAddress("42 Main St");
        company.setCompanyCEO("Company CEO");
        company.setCompanyName("Company Name");
        company.setInceptionDate("2020-03-01");
        company.setTeam(new ArrayList<>());
        company.setUUID(1);
        Optional<Company> ofResult = Optional.of(company);
        when(companyRepo.getComapanyByName((String) any())).thenReturn(ofResult);
        CompanyResponse actualCompanyByName = companyService.getCompanyByName("Name");
        assertEquals("42 Main St", actualCompanyByName.getCompanyAddress());
        assertEquals(1, actualCompanyByName.getUUID());
        assertEquals("2020-03-01", actualCompanyByName.getInceptionDate());
        assertEquals("Company Name", actualCompanyByName.getCompanyName());
        assertEquals("Company CEO", actualCompanyByName.getCompanyCEO());
        verify(companyRepo).getComapanyByName((String) any());
    }


    @Test
    void testGetCompanyByName2() {
        Company company = mock(Company.class);
        CompanyResponse companyResponse = new CompanyResponse(1, "Company Name", "Company CEO", "42 Main St", "2020-03-01");

        when(company.toCompanyResponse()).thenReturn(companyResponse);
        doNothing().when(company).setCompanyAddress((String) any());
        doNothing().when(company).setCompanyCEO((String) any());
        doNothing().when(company).setCompanyName((String) any());
        doNothing().when(company).setInceptionDate((String) any());
        doNothing().when(company).setTeam((List<Team>) any());
        doNothing().when(company).setUUID(anyInt());
        company.setCompanyAddress("42 Main St");
        company.setCompanyCEO("Company CEO");
        company.setCompanyName("Company Name");
        company.setInceptionDate("2020-03-01");
        company.setTeam(new ArrayList<>());
        company.setUUID(1);
        Optional<Company> ofResult = Optional.of(company);
        when(companyRepo.getComapanyByName((String) any())).thenReturn(ofResult);
        assertSame(companyResponse, companyService.getCompanyByName("Name"));
        verify(companyRepo).getComapanyByName((String) any());
        verify(company).toCompanyResponse();
        verify(company).setCompanyAddress((String) any());
        verify(company).setCompanyCEO((String) any());
        verify(company).setCompanyName((String) any());
        verify(company).setInceptionDate((String) any());
        verify(company).setTeam((List<Team>) any());
        verify(company).setUUID(anyInt());
    }

    @Test
    void testGetCompanyByName3() {
        when(companyRepo.getComapanyByName((String) any())).thenReturn(Optional.empty());
        Company company = mock(Company.class);
        company.setCompanyAddress("42 Main St");
        company.setCompanyCEO("Company CEO");
        company.setCompanyName("Company Name");
        company.setInceptionDate("2020-03-01");
        company.setTeam(new ArrayList<>());
        company.setUUID(1);
        assertThrows(NotFoundExecption.class, () -> companyService.getCompanyByName("Name"));
        verify(companyRepo).getComapanyByName((String) any());
        verify(company).setCompanyAddress((String) any());
        verify(company).setCompanyCEO((String) any());
        verify(company).setCompanyName((String) any());
        verify(company).setInceptionDate((String) any());
        verify(company).setTeam((List<Team>) any());
        verify(company).setUUID(anyInt());
    }

}