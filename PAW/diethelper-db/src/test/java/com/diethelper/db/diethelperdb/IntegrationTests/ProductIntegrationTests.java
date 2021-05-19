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
public class ProductIntegrationTests {
    private final String username = "test";
    private final String password = "test";

    @Autowired
    private MockMvc mockMvc;

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getAll()")
    public void shouldExecuteGetAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/all"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getProductById()")
    public void shouldExecuteGetProductById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/1"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should not execute getProductById()")
    public void shouldNotExecuteGetProductById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/x"))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute default")
    public void shouldExecuteDefault() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

}
