package com.example.Techwondoe.ObjectCreation;

import com.example.Techwondoe.models.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TeamObj {
    private String leadName;

    public Team toTeam(Company company){
        return Team.builder()
                .company(company)
                .leadName(this.leadName)
                .build();
    }
}
