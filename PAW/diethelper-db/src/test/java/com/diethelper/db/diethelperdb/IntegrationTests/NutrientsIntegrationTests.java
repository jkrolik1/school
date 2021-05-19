package com.diethelper.db.diethelperdb.IntegrationTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class NutrientsIntegrationTests {
    private final String username = "test";
    private final String password = "test";

    @Autowired
    private MockMvc mockMvc;

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getAll()")
    public void shouldExecuteGetAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/nutrients/all"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getNutrientsById()")
    public void shouldExecuteGetNutrientsById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/nutrients/1"))
                .andExpect(MockMvcResultMatchers.status().is(204));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should not execute getNutrientsById()")
    public void shouldNotExecuteGetNutrientsById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/nutrients/x"))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute default")
    public void shouldExecuteDefault() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/nutrients/"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

}
