package com.example.Techwondoe.ObjectCreation;

import com.example.Techwondoe.models.Company;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ComapnyObj {
    private String companyName;

    private String companyCEO;

    private String companyAddress;

    private String inceptionDate;

    public Company toCompany(){
        return Company.builder().companyCEO(this.companyCEO)
                .companyAddress(this.companyAddress)
                .companyName(this.companyName)
                .inceptionDate(this.inceptionDate)
                .build();
    }
}
