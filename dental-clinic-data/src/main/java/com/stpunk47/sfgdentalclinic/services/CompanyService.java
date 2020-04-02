package com.stpunk47.sfgdentalclinic.services;

import com.stpunk47.sfgdentalclinic.model.Company;


public interface CompanyService extends CrudService<Company, Long>{

    Company findByLastName(String lastName);


}
