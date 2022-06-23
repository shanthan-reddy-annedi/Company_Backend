package com.example.Techwondoe.Controllers;

import com.example.Techwondoe.ObjectCreation.AppUserObj;
import com.example.Techwondoe.Service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @PostMapping("/create/user")
    public String createAppUser(@RequestBody AppUserObj appUserObj){
        return appUserService.createAppUser(appUserObj);
    }
}
