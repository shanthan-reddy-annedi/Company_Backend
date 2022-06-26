package com.example.Techwondoe;


import com.example.Techwondoe.ObjectCreation.AppUserObj;
import com.example.Techwondoe.Repositories.AppUserRepo;
import com.example.Techwondoe.Repositories.CompanyRepo;
import com.example.Techwondoe.Repositories.TeamRepo;
import com.example.Techwondoe.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;

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
		try {
			AppUserObj appUserObj = AppUserObj.builder()
					.username("admin")
					.password(new BCryptPasswordEncoder().encode("admin"))
					.authorities("admin")
					.build();
			AppUser appUser = appUserObj.toAppUser();
			appUserRepo.save(appUser);
		}catch (Exception e){

		}
	}

}
