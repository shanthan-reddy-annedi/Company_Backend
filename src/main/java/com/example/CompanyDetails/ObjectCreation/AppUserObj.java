package com.example.CompanyDetails.ObjectCreation;

import com.example.CompanyDetails.models.AppUser;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AppUserObj {
    @NotNull()
    private String username;
    @NotNull()
    @Size(min=8, max=12)
    private String password;
    @NotNull()
    private String authorities;

    public AppUser toAppUser(){
        return AppUser.builder()
                .username(this.username)
                .password(new BCryptPasswordEncoder().encode(this.password))
                .authorites(this.authorities)
                .build();
    }

}
