package com.example.CompanyDetails;


import com.example.CompanyDetails.Repositories.AppUserRepo;
import com.example.CompanyDetails.Repositories.CompanyRepo;
import com.example.CompanyDetails.Repositories.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompanyDetailsApplication implements CommandLineRunner {
	@Autowired
	AppUserRepo appUserRepo;

	@Autowired
	CompanyRepo companyRepo;

	@Autowired
	TeamRepo teamRepo;
	public static void main(String[] args) {
		SpringApplication.run(CompanyDetailsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//		try {
//			AppUserObj appUserObj = AppUserObj.builder()
//					.username("admin")
//					.password(new BCryptPasswordEncoder().encode("admin"))
//					.authorities("admin")
//					.build();
//			AppUser appUser = appUserObj.toAppUser();
//			appUserRepo.save(appUser);
//		}catch (Exception e){
//
//		}
//		System.out.println(new BCryptPasswordEncoder().matches("admin","$2a$10$TzA6EvJAxKW5/lhMfRi/ROjkKzaHwZzCkgzLy9AsIRGBZfeQWp/1e"));
//	}
	}
}
