package com.example.Techwondoe.Repositories;

import com.example.Techwondoe.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppUserRepo extends JpaRepository<AppUser, Integer> {

    @Query("select u from AppUser u where u.username= :name")
    AppUser getUserByName(String name);
}