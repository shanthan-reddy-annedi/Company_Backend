package com.example.Techwondoe.Service;

import com.example.Techwondoe.ObjectCreation.AppUserObj;
import com.example.Techwondoe.Repositories.AppUserRepo;
import com.example.Techwondoe.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = appUserRepo.getUserByName(username);
        if(userDetails != null)
            return userDetails;
        throw new UsernameNotFoundException("Wrong User");
    }

    public String createAppUser(AppUserObj appUserObj){
        AppUser appUser = appUserObj.toAppUser();
        try{
            appUserRepo.save(appUser);
            return "User Saved Sucessfully";
        }catch (Exception e){
            return "Unable to Create AppUser";
        }
    }
}
