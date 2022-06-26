package com.example.Techwondoe.Controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.Techwondoe.ObjectCreation.ComapnyObj;
import com.example.Techwondoe.Responses.CompanyResponse;
import com.example.Techwondoe.Service.CompanyService;
import com.example.Techwondoe.models.Company;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CompanyController.class})
@ExtendWith(SpringExtension.class)
class CompanyControllerTest {
    @Autowired
    private CompanyController companyController;

    @MockBean
    private CompanyService companyService;

    /**
     * Method under test: {@link CompanyController#createCompany(ComapnyObj)}
     */
    @Test
    void testCreateCompany() throws Exception {
        doNothing().when(companyService).saveCompany((Company) any());

        ComapnyObj comapnyObj = new ComapnyObj();
        comapnyObj.setCompanyAddress("42 Main St");
        comapnyObj.setCompanyCEO("Company CEO");
        comapnyObj.setCompanyName("Company Name");
        comapnyObj.setInceptionDate("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(comapnyObj);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/company/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(companyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CompanyController#getCompanyByName(String)}
     */
    @Test
    void testGetCompanyByName() throws Exception {
        when(companyService.getCompanyByName((String) any()))
                .thenReturn(new CompanyResponse(1, "Company Name", "Company CEO", "42 Main St", "2020-03-01"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get/company/byname/{name}", "Name");
        MockMvcBuilders.standaloneSetup(companyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"companyName\":\"Company Name\",\"companyCEO\":\"Company CEO\",\"companyAddress\":\"42 Main St\",\"inceptionDate"
                                        + "\":\"2020-03-01\",\"uuid\":1}"));
    }

    /**
     * Method under test: {@link CompanyController#getCompanyById(int)}
     */
    @Test
    void testGetCompanyById() throws Exception {
        Company company = new Company();
        company.setCompanyAddress("42 Main St");
        company.setCompanyCEO("Company CEO");
        company.setCompanyName("Company Name");
        company.setInceptionDate("2020-03-01");
        company.setTeam(new ArrayList<>());
        company.setUUID(1);
        when(companyService.getCompanyWithTeam(anyInt())).thenReturn(company);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get/company/byid/{id}", 1);
        MockMvcBuilders.standaloneSetup(companyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"companyName\":\"Company Name\",\"companyCEO\":\"Company CEO\",\"companyAddress\":\"42 Main St\",\"inceptionDate"
                                        + "\":\"2020-03-01\",\"uuid\":1}"));
    }
}

