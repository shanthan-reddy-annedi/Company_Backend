package com.example.Techwondoe.Repositories;

import com.example.Techwondoe.Responses.CompanyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Techwondoe.models.*;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

    @Query("select u from Company u where u.companyName= :name")
    Company getComapanyByName(String name);
}
