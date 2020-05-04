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

import static org.hamcrest.Matchers.hasSize;
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
    void listCompanies() throws Exception {
        when(companyService.findAll()).thenReturn(companies);

        mockMvc.perform(get("/companies"))
                .andExpect(status().isOk())
                .andExpect(view().name("/companies/index"))
                .andExpect(model().attribute("companies", hasSize(2)));

    }

    @Test
    void findCompanies() throws Exception {

        mockMvc.perform(get("/companies/find"))
        .andExpect(status().isOk())
        .andExpect(view().name("notImplemented"));


    }
}