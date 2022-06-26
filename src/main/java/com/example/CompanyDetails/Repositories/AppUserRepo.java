package com.example.CompanyDetails.Repositories;

import com.example.CompanyDetails.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AppUserRepo extends JpaRepository<AppUser, Integer> {

    @Query("select u from AppUser u where u.username= :name")
    Optional<AppUser> getUserByName(String name);
}
