package com.stpunk47.sfgdentalclinic.services.springdatajpa;

import com.stpunk47.sfgdentalclinic.model.Company;
import com.stpunk47.sfgdentalclinic.repositories.CompanyRepository;
import com.stpunk47.sfgdentalclinic.repositories.DepartmentRepository;
import com.stpunk47.sfgdentalclinic.repositories.WorkerRepository;
import com.stpunk47.sfgdentalclinic.services.CompanyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class CompanySDJpaService implements CompanyService {

    private final CompanyRepository companyRepository;
    private final WorkerRepository workerRepository;
    private final DepartmentRepository departmentRepository;

    public CompanySDJpaService(CompanyRepository companyRepository, WorkerRepository workerRepository, DepartmentRepository departmentRepository) {
        this.companyRepository = companyRepository;
        this.workerRepository = workerRepository;
        this.departmentRepository = departmentRepository;
    }


    @Override
    public Company findByLastName(String lastName) {
        return companyRepository.findByLastName(lastName);
    }

    @Override
    public Set<Company> findAll() {
        Set<Company> companies = new HashSet<>();
        companyRepository.findAll().forEach(companies::add);
        return companies;
    }

    @Override
    public Company findById(Long aLong) {
        return companyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Company save(Company object) {
        return companyRepository.save(object);
    }

    @Override
    public void delete(Company object) {
        companyRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        companyRepository.deleteById(aLong);
    }
}
