package com.example.Techwondoe.Responses;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyResponse {
    private int UUID;
    private String companyName;
    private String companyCEO;
    private String companyAddress;
    private String inceptionDate;
}
