package com.stpunk47.sfgdentalclinic.bootstrap;

import com.stpunk47.sfgdentalclinic.model.Company;
import com.stpunk47.sfgdentalclinic.model.Dentist;
import com.stpunk47.sfgdentalclinic.model.Department;
import com.stpunk47.sfgdentalclinic.services.CompanyService;
import com.stpunk47.sfgdentalclinic.services.DentistService;
import com.stpunk47.sfgdentalclinic.services.DepartmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        generalManagement.setNameOfDepartment("General Management");
        Department savedGeneralManagementDepartment = departmentService.save(generalManagement);

        Department marketing = new Department();
        marketing.setNameOfDepartment("Marketing");
        Department savedMarketingDepartment = departmentService.save(marketing);



        Company company1 = new Company();

        company1.setFirstName("ALLO");
        company1.setLastName("TOV");
        companyService.save(company1);

        Company company2 = new Company();

        company2.setFirstName("BRW");
        company2.setLastName("TOV");
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
