package com.example.Techwondoe.Repositories;

import com.example.Techwondoe.models.Company;
import com.example.Techwondoe.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Integer> {
}
