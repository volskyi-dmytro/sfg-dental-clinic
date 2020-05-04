package com.stpunk47.sfgdentalclinic.services.springdatajpa;

import com.stpunk47.sfgdentalclinic.model.Company;
import com.stpunk47.sfgdentalclinic.repositories.CompanyRepository;
import com.stpunk47.sfgdentalclinic.repositories.DepartmentRepository;
import com.stpunk47.sfgdentalclinic.repositories.WorkerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompanySDJpaServiceTest {

    public static final String LAST_NAME = "BRV";
    @Mock
    CompanyRepository companyRepository;

    @Mock
    WorkerRepository workerRepository;

    @Mock
    DepartmentRepository departmentRepository;

    @InjectMocks
    CompanySDJpaService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        Company returnCompany = Company.builder().id(5L).firstName("TOV").lastName(LAST_NAME).build();

        when(companyRepository.findByLastName(any())).thenReturn(returnCompany);

        Company company = companyRepository.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, company.getLastName());
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteByID() {
    }
}