package com.example.Techwondoe.Controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.example.Techwondoe.ObjectCreation.TeamObj;
import com.example.Techwondoe.Service.TeamService;
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

@ContextConfiguration(classes = {TeamController.class})
@ExtendWith(SpringExtension.class)
class TeamControllerTest {
    @Autowired
    private TeamController teamController;

    @MockBean
    private TeamService teamService;


    @Test
    void testCreateTeam() throws Exception {
        when(teamService.saveTeam((TeamObj) any(), anyInt())).thenReturn("Save Team");

        TeamObj teamObj = new TeamObj();
        teamObj.setLeadName("Lead Name");
        String content = (new ObjectMapper()).writeValueAsString(teamObj);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/create/team/company/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(teamController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Save Team"));
    }


    @Test
    void testGetCompany() throws Exception {
        when(teamService.getAllTeams()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/get/teams");
        MockMvcBuilders.standaloneSetup(teamController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetCompany2() throws Exception {
        when(teamService.getAllTeams()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/get/teams");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(teamController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

