package com.stpunk47.sfgdentalclinic.services;

import com.stpunk47.sfgdentalclinic.model.Company;

import java.util.List;


public interface CompanyService extends CrudService<Company, Long>{

    Company findByLastName(String lastName);

    List<Company> findAllByLastNameLike(String lastName);
}
