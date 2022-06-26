package com.example.Techwondoe.Controllers;

import com.example.Techwondoe.ObjectCreation.AppUserObj;
import com.example.Techwondoe.Service.AppUserService;
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
