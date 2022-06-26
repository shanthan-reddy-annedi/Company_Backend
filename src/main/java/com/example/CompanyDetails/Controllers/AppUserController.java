package com.example.CompanyDetails.Controllers;

import com.example.CompanyDetails.ObjectCreation.AppUserObj;
import com.example.CompanyDetails.Service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/api/create/user")
    public String createAppUser(@Valid @RequestBody AppUserObj appUserObj){
        return appUserService.createAppUser(appUserObj);
    }
}
