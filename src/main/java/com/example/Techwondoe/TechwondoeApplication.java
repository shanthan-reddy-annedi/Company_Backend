package com.example.Techwondoe;


import com.example.Techwondoe.Repositories.AppUserRepo;
import com.example.Techwondoe.Repositories.CompanyRepo;
import com.example.Techwondoe.Repositories.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechwondoeApplication implements CommandLineRunner {
	@Autowired
	AppUserRepo appUserRepo;

	@Autowired
	CompanyRepo companyRepo;

	@Autowired
	TeamRepo teamRepo;
	public static void main(String[] args) {
		SpringApplication.run(TechwondoeApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

	}
}
