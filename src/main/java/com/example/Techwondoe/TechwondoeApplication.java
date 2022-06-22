package com.example.Techwondoe;

import com.example.Techwondoe.ObjectCreation.ComapnyObj;
import com.example.Techwondoe.ObjectCreation.TeamObj;
import com.example.Techwondoe.Repositories.AppUserRepo;
import com.example.Techwondoe.Repositories.CompanyRepo;
import com.example.Techwondoe.Repositories.TeamRepo;
import com.example.Techwondoe.models.AppUser;
import com.example.Techwondoe.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

//		Company company1 = ComapnyObj.builder()
//				.companyAddress("Hyderabad")
//				.companyCEO("shanthan reddy")
//				.companyName("ASR Limiteds")
//				.inceptionDate("12-05-2019")
//				.build().toCompany();
//
//		Company company2 =ComapnyObj.builder()
//				.companyAddress("Hyderabad")
//				.companyCEO("thirupathi reddy")
//				.companyName("Reddy Limiteds")
//				.inceptionDate("20-07-2009")
//				.build().toCompany();
//		companyRepo.save(company1);
//		companyRepo.save(company2);
//
//		AppUser appUser1 = AppUser.builder().username("asr").password(new BCryptPasswordEncoder().encode("asr")).authorites("admin").build();
//		AppUser appUser2 = AppUser.builder().username("read").password(new BCryptPasswordEncoder().encode("asr")).authorites("read").build();
//
//		appUserRepo.save(appUser1);
//		appUserRepo.save(appUser2);
//
//		teamRepo.save(TeamObj.builder().leadName("Samatha").build().toTeam(company1));
//		teamRepo.save(TeamObj.builder().leadName("Jyoti").build().toTeam(company2));

	}
}
