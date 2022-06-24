package com.example.Techwondoe.Controllers;

import com.example.Techwondoe.ObjectCreation.AppUserObj;
import com.example.Techwondoe.Service.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/api/create/user")
    public String createAppUser(@Valid @RequestBody AppUserObj appUserObj){
        log.info(appUserObj.getUsername()+appUserObj.getPassword()+appUserObj.getAuthorities());
        return appUserService.createAppUser(appUserObj);
    }
}
