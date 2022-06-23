package com.example.Techwondoe.ObjectCreation;

import com.example.Techwondoe.models.AppUser;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AppUserObj {
    private String username;
    private String password;
    private String authorites;

    public AppUser toAppUser(){
        return AppUser.builder()
                .username(this.username)
                .password(this.password)
                .authorites(this.authorites)
                .build();
    }

}
