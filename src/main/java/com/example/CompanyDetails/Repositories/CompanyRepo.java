package com.example.CompanyDetails.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CompanyDetails.models.*;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

    @Query("select u from Company u where u.companyName= :name")
    Optional<Company> getComapanyByName(String name);
}
