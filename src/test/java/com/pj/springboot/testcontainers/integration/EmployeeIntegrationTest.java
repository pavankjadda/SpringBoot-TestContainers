package com.pj.springboot.testcontainers.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pj.springboot.testcontainers.domain.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles(value = "local")
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeIntegrationTest extends BaseTest {
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
        //@Sql({"/import.sql"})
    void findAll_ReturnAllEmployees_WhenImportedDataViaSqlFile() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/api/v1/employee/find/all")).andExpect(status().isOk()).andReturn();
        var employees = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Employee[].class);
        assertTrue(Arrays.stream(employees).anyMatch(employee -> employee.getEmail().equals("jdoe@example.com")));
    }

    @Test
    void findAll_ReturnNoEmployees_WhenDataIsNotImported() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/api/v1/employee/find/all")).andExpect(status().isOk()).andReturn();
        var employees = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Employee[].class);
        assertTrue(Arrays.stream(employees).anyMatch(employee -> employee.getEmail().equals("jdoe@example.com")));
    }

}
