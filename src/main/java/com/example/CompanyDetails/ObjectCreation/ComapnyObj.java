package com.example.CompanyDetails.ObjectCreation;

import com.example.CompanyDetails.models.Company;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ComapnyObj {
    @NotNull
    private String companyName;

    @NotNull
    private String companyCEO;

    @NotNull
    private String companyAddress;

    @NotNull
    private String inceptionDate;

    public Company toCompany(){
        return Company.builder().companyCEO(this.companyCEO)
                .companyAddress(this.companyAddress)
                .companyName(this.companyName)
                .inceptionDate(this.inceptionDate)
                .build();
    }
}
