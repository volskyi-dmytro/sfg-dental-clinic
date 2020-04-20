package com.stpunk47.sfgdentalclinic.bootstrap;

import com.stpunk47.sfgdentalclinic.model.*;
import com.stpunk47.sfgdentalclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final CompanyService companyService;
    private final DentistService dentistService;
    private final DepartmentService departmentService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;




    public DataLoader(CompanyService companyService,
                      DentistService dentistService,
                      DepartmentService departmentService,
                      SpecialtyService specialtyService,
                      VisitService visitService) {
        this.companyService = companyService;
        this.dentistService = dentistService;
        this.departmentService = departmentService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = departmentService.findAll().size();

        if(count == 0){
            loadData();
        }


    }

    private void loadData() {
        Department generalManagement = new Department();
        generalManagement.setName("General Management");
        Department savedGeneralManagementDepartment = departmentService.save(generalManagement);

        Department marketing = new Department();
        marketing.setName("Marketing");
        Department savedMarketingDepartment = departmentService.save(marketing);

        Specialty endodontist = new Specialty();
        endodontist.setDescription("Endodontist");
        Specialty savedEndodontist = specialtyService.save(endodontist);

        Specialty orthodontist = new Specialty();
        endodontist.setDescription("Orthodontist");
        Specialty savedOthodontist = specialtyService.save(orthodontist);

        Specialty periodontist = new Specialty();
        endodontist.setDescription("Periodontist");
        Specialty savedPeriodontist = specialtyService.save(periodontist);

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

        Visit pavloVisit = new Visit();
        pavloVisit.setWorker(brw1);
        pavloVisit.setDate(LocalDate.now());
        pavloVisit.setDescription("Scheduled inspection");
        visitService.save(pavloVisit);


        System.out.println("Loaded companies");

        Dentist dentist1 = new Dentist();
        dentist1.setFirstName("Andrew");
        dentist1.setLastName("Pavlov");
        dentistService.save(dentist1);
        dentist1.getSpecialties().add(savedOthodontist);

        Dentist dentist2 = new Dentist();
        dentist2.setFirstName("Volodymyr");
        dentist2.setLastName("Bortnikov");
        dentistService.save(dentist2);
        dentist2.getSpecialties().add(savedPeriodontist);

        System.out.println("Loaded dentists...");
    }
}
