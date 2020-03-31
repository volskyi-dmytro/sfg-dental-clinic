package com.stpunk47.sfgdentalclinic.services;

import com.stpunk47.sfgdentalclinic.model.Company;

import java.util.Set;

public interface CompanyService {

    Company findByLastName(String lastName);

    Company findById(Long id);

    Company save(Company company);

    Set<Company> findAll();
}
