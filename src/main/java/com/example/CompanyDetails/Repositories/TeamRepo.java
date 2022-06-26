package com.example.CompanyDetails.Repositories;

import com.example.CompanyDetails.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Integer> {
}
