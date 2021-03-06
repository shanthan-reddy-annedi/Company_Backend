package com.example.CompanyDetails.ObjectCreation;

import com.example.CompanyDetails.models.*;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TeamObj {
    @NotNull
    private String leadName;

    public Team toTeam(Company company){
        return Team.builder()
                .company(company)
                .leadName(this.leadName)
                .build();
    }
}
