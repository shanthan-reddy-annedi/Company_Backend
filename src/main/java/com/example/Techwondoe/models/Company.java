package com.example.Techwondoe.models;


import com.example.Techwondoe.Responses.CompanyResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //primary key
    private int UUID;

    @Column(nullable = false, unique = true)
    private String companyName;

    private String companyCEO;

    private String companyAddress;

    private String inceptionDate;

    @OneToMany(mappedBy = "company")
    @JsonIgnoreProperties("company")
    private List<Team> team;

    public CompanyResponse toCompanyResponse(){
        return CompanyResponse.builder()
                .companyAddress(this.companyAddress)
                .companyCEO(this.companyCEO)
                .companyName(this.companyName)
                .inceptionDate(this.inceptionDate)
                .UUID(this.UUID)
                .build();
    }

}
