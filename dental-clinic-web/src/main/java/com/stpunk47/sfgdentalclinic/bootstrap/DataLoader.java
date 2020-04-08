package com.stpunk47.sfgdentalclinic.bootstrap;

import com.stpunk47.sfgdentalclinic.model.Company;
import com.stpunk47.sfgdentalclinic.model.Dentist;
import com.stpunk47.sfgdentalclinic.model.Department;
import com.stpunk47.sfgdentalclinic.model.Worker;
import com.stpunk47.sfgdentalclinic.services.CompanyService;
import com.stpunk47.sfgdentalclinic.services.DentistService;
import com.stpunk47.sfgdentalclinic.services.DepartmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final CompanyService companyService;
    private final DentistService dentistService;
    private final DepartmentService departmentService;




    public DataLoader(CompanyService companyService, DentistService dentistService, DepartmentService departmentService) {
        this.companyService = companyService;

        this.dentistService = dentistService;

        this.departmentService = departmentService;
    }

    @Override
    public void run(String... args) throws Exception {

        Department generalManagement = new Department();
        generalManagement.setName("General Management");
        Department savedGeneralManagementDepartment = departmentService.save(generalManagement);

        Department marketing = new Department();
        marketing.setName("Marketing");
        Department savedMarketingDepartment = departmentService.save(marketing);



        Company company1 = new Company();

        company1.setFirstName("ALLO");
        company1.setLastName("TOV");
        company1.setAddress("Peremogy Avn.1");
        company1.setCity("Novovolynsk");
        company1.setPhone("0667442918");


        Worker allo1 = new Worker();
        allo1.setDepartment(savedMarketingDepartment);
        allo1.setCompany(company1);
        allo1.setFirstName("Alina");
        allo1.setLastName("Muzyka");
        allo1.setBirthday(LocalDate.of(1985,10,26));
        company1.getWorkers().add(allo1);

        companyService.save(company1);


        Company company2 = new Company();

        company2.setFirstName("BRW");
        company2.setLastName("TOV");
        company2.setAddress("Lutska, 26");
        company2.setCity("Novovolynsk");
        company2.setPhone("0334446024");

        Worker brw1 = new Worker();
        brw1.setDepartment(savedGeneralManagementDepartment);
        brw1.setCompany(company2);
        brw1.setFirstName("Pavlo");
        brw1.setLastName("Pylypyuk");
        brw1.setBirthday(LocalDate.of(1986,8,5));
        company2.getWorkers().add(brw1);

        companyService.save(company2);



        System.out.println("Loaded companies");

        Dentist dentist1 = new Dentist();

        dentist1.setFirstName("Andrew");
        dentist1.setLastName("Pavlov");
        dentistService.save(dentist1);

        Dentist dentist2 = new Dentist();

        dentist2.setFirstName("Volodymyr");
        dentist2.setLastName("Bortnikov");
        dentistService.save(dentist2);

        System.out.println("Loaded dentists...");


    }
}
