package com.example.CompanyDetails.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UUID;
    @JoinColumn
    @ManyToOne
    @JsonIgnoreProperties("team")
    private Company company;

    @Column(nullable = false)
    private String leadName;
}
