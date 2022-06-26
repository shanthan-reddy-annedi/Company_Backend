package com.example.CompanyDetails.Repositories;

import com.example.CompanyDetails.models.AppUser;
import com.example.CompanyDetails.models.Authorites;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class AppUserRepoTest {

    @Autowired
    AppUserRepo underTest;

    @Test
    void getUserByNameValidUser() {
        AppUser appUser = AppUser.builder()
                .username("asr")
                .password(new BCryptPasswordEncoder().encode("asr"))
                .authorites(Authorites.ADMIN)
                .build();

        underTest.save(appUser);

        AppUser appUser1 = underTest.getUserByName("asr").orElse(null);

        assertThat(appUser1).isEqualTo(appUser);
    }

    @Test
    void getUserByNameInValidUser() {

        AppUser appUser = underTest.getUserByName("admin").orElse(null);

        assertThat(appUser).isEqualTo(null);
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

}