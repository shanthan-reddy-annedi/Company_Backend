package com.example.CompanyDetails.Controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.example.CompanyDetails.ObjectCreation.AppUserObj;
import com.example.CompanyDetails.Service.AppUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@ContextConfiguration(classes = {AppUserController.class})
@ExtendWith(SpringExtension.class)
class AppUserControllerTest {
    @Autowired
    private AppUserController appUserController;

    @MockBean
    private AppUserService appUserService;

    @Test
    void testCreateAppUser() throws Exception {
        when(appUserService.createAppUser((AppUserObj) any())).thenReturn("Create App User");

        AppUserObj appUserObj = AppUserObj.builder()
                .authorities("admin")
                .password("password")
                .username("doe")
                .build();
        String content = (new ObjectMapper()).writeValueAsString(appUserObj);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/create/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(appUserController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Create App User"));
    }
}

