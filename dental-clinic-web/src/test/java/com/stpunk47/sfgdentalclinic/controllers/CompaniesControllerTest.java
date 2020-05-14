package com.stpunk47.sfgdentalclinic.controllers;

import com.stpunk47.sfgdentalclinic.model.Company;
import com.stpunk47.sfgdentalclinic.services.CompanyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class CompaniesControllerTest {

    @Mock
    CompanyService companyService;

    @InjectMocks
    CompaniesController controller;


    Set<Company> companies;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        companies = new HashSet<>();
        companies.add(Company.builder().id(1L).build());
        companies.add(Company.builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }


    @Test
    void findCompanies() throws Exception {

        mockMvc.perform(get("/companies/find"))
        .andExpect(status().isOk())
       .andExpect(view().name("companies/findCompanies"))
        .andExpect(model().attributeExists("companies"));


    }




    @Test
    void displayCompany() throws Exception{
        when(companyService.findById(anyLong())).thenReturn(Company.builder().id(1L).build());

        mockMvc.perform(get("/companies/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("companies/companyDetails"))
                .andExpect(model().attribute("company", hasProperty("id", is(1L))));

    }


}