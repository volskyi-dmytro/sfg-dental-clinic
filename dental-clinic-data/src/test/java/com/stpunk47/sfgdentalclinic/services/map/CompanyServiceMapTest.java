package com.stpunk47.sfgdentalclinic.services.map;

import com.stpunk47.sfgdentalclinic.model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceMapTest {

    CompanyServiceMap companyServiceMap;
    final Long companyId = 15L;
    final String lastName = "Ivanov";

    @BeforeEach
    void setUp() {
        companyServiceMap = new CompanyServiceMap(new DepartmentMapService(), new WorkerServiceMap());

        companyServiceMap.save(Company.builder().id(companyId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Company> companiesSet = companyServiceMap.findAll();

        assertEquals(1, companiesSet.size());
    }

    @Test
    void findById() {
        Company company = companyServiceMap.findById(companyId);

        assertEquals(15L, company.getId());

    }

    @Test
    void saveExistingId() {
        Long id = 3L;
        Company company2 = Company.builder().id(id).build();
        Company savedCompany = companyServiceMap.save(company2);

        assertEquals(id, savedCompany.getId());

    }

    @Test
        void saveNoId() {
            Company savedCompany = companyServiceMap.save(Company.builder().build());

            assertNotNull(savedCompany);
            assertNotNull(savedCompany.getId());


    }

    @Test
    void delete() {
        companyServiceMap.deleteById(companyId);

        assertEquals(0, companyServiceMap.findAll().size());
    }

    @Test
    void deleteByID() {
        companyServiceMap.deleteById(companyId);

        assertEquals(0, companyServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Company company = companyServiceMap.findByLastName(lastName);

        assertNotNull(company);

        assertEquals(companyId, company.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Company company = companyServiceMap.findByLastName("test");

        assertNull(company);
    }
}