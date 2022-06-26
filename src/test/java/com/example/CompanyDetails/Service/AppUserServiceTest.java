package com.example.CompanyDetails.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.CompanyDetails.ObjectCreation.AppUserObj;
import com.example.CompanyDetails.Repositories.AppUserRepo;
import com.example.CompanyDetails.models.AppUser;
import com.example.CompanyDetails.models.Authorites;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AppUserService.class})
@ExtendWith(SpringExtension.class)
class AppUserServiceTest {
    @MockBean
    private AppUserRepo appUserRepo;

    @Autowired
    private AppUserService appUserService;


    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        AppUser appUser = new AppUser();
        when(appUserRepo.getUserByName((String) any())).thenReturn(Optional.of(appUser));
        assertSame(appUser, appUserService.loadUserByUsername("janedoe"));
        verify(appUserRepo).getUserByName((String) any());
    }


    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        when(appUserRepo.getUserByName((String) any())).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> appUserService.loadUserByUsername("janedoe"));
        verify(appUserRepo).getUserByName((String) any());
    }


    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        when(appUserRepo.getUserByName((String) any())).thenThrow(new UsernameNotFoundException("Wrong User!"));
        assertThrows(UsernameNotFoundException.class, () -> appUserService.loadUserByUsername("janedoe"));
        verify(appUserRepo).getUserByName((String) any());
    }


    @Test
    void testCreateAppUser() {
        when(appUserRepo.save((AppUser) any())).thenReturn(new AppUser());
        assertEquals("User Saved Sucessfully",
                appUserService.createAppUser(new AppUserObj("janedoe", "iloveyou", Authorites.ADMIN)));
        verify(appUserRepo).save((AppUser) any());
    }


    @Test
    void testCreateAppUser3() {
        when(appUserRepo.save((AppUser) any())).thenReturn(new AppUser());
        AppUserObj appUserObj = mock(AppUserObj.class);
        when(appUserObj.toAppUser()).thenReturn(new AppUser());
        assertEquals("User Saved Sucessfully", appUserService.createAppUser(appUserObj));
        verify(appUserRepo).save((AppUser) any());
        verify(appUserObj).toAppUser();
    }


    @Test
    void testCreateAppUser4() {
        when(appUserRepo.save((AppUser) any())).thenThrow(new UsernameNotFoundException("User Saved Sucessfully"));
        assertEquals("Unable to Create AppUser",
                appUserService.createAppUser(new AppUserObj("janedoe", "iloveyou", Authorites.ADMIN)));
        verify(appUserRepo).save((AppUser) any());
    }
}

