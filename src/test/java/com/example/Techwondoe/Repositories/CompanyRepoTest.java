package com.example.Techwondoe.Repositories;

import com.example.Techwondoe.models.Company;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CompanyRepoTest {

    @Autowired
    CompanyRepo underTest;

    @Test
    void getComapanyByName() {
        //given
        Company company = Company.builder()
                .companyName("TechWondo")
                .companyAddress("bangalore")
                .companyCEO("josh")
                .inceptionDate("12-05-2016")
                .build();

        underTest.save(company);
        //when
        Company company1 = underTest.getComapanyByName("TechWondo").orElse(null);
        //then
        assertThat(company1).isEqualTo(company);
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void getComapanyByNameWontFetches() {
        //given
        String name = "hello";
        //when
        Company company1 = underTest.getComapanyByName("TechWondo").orElse(null);
        //then
        assertThat(company1).isEqualTo(null);
    }

}