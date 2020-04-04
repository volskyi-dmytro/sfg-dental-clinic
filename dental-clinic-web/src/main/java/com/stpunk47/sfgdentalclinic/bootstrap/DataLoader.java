package com.stpunk47.sfgdentalclinic.bootstrap;

import com.stpunk47.sfgdentalclinic.model.Company;
import com.stpunk47.sfgdentalclinic.model.Dentist;
import com.stpunk47.sfgdentalclinic.services.CompanyService;
import com.stpunk47.sfgdentalclinic.services.DentistService;
import com.stpunk47.sfgdentalclinic.services.map.CompanyServiceMap;
import com.stpunk47.sfgdentalclinic.services.map.DentistServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CompanyService companyService;
    private final DentistService dentistService;




    public DataLoader() {
        companyService = new CompanyServiceMap();
        dentistService = new DentistServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Company company1 = new Company();
        company1.setId(1L);
        company1.setFirstName("ALLO");
        company1.setLastName("TOV");
        companyService.save(company1);

        Company company2 = new Company();
        company2.setId(2L);
        company2.setFirstName("BRW");
        company2.setLastName("TOV");
        companyService.save(company2);

        System.out.println("Loaded companies");

        Dentist dentist1 = new Dentist();
        dentist1.setId(1L);
        dentist1.setFirstName("Andrew");
        dentist1.setLastName("Pavlov");
        dentistService.save(dentist1);

        Dentist dentist2 = new Dentist();
        dentist1.setId(2L);
        dentist2.setFirstName("Volodymyr");
        dentist2.setLastName("Bortnikov");
        dentistService.save(dentist2);

        System.out.println("Loaded dentists...");


    }
}
