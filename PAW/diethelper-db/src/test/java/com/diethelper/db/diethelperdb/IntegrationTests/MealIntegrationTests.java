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
public class MealIntegrationTests {

    private final String username = "test";
    private final String password = "test";

    @Autowired
    private MockMvc mockMvc;

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getAll()")
    public void shouldExecuteGetAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/all"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getRandom()")
    public void shouldExecuteGetRandom() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/random"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealDefault() - test 1")
    public void shouldExecuteGetMealDefault1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealDefault() - test 2")
    public void shouldExecuteGetMealDefault2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/categories"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealDefault() - test 3")
    public void shouldExecuteGetMealDefault3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/flavor"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealDefault() - test 4")
    public void shouldExecuteGetMealDefault4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/difficultyOfCooking"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should not execute getMealDefault() - test 1")
    public void shouldNotExecuteGetMealDefault1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meals/"))
                .andExpect(MockMvcResultMatchers.status().is(404));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should not execute getMealDefault() - test 2")
    public void shouldNotExecuteGetMealDefault2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/meals/"))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should not execute getMealDefault() - test 3")
    public void shouldNotExecuteGetMealDefault3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/category/"))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealByCategory() - śniadanie")
    public void shouldExecuteGetMealByCategory1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/categories/śniadanie"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealByCategory() - obiad")
    public void shouldExecuteGetMealByCategory2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/categories/obiad"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealByCategory() - kolacja")
    public void shouldExecuteGetMealByCategory3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/categories/kolacja"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealByCategory() - kilka")
    public void shouldExecuteGetMealByCategory4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/categories/śniadanie,kolacja"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealByFlavor()")
    public void shouldExecuteGetMealByFlavor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/flavor/słodki"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealByDifficultyOfCooking()")
    public void shouldExecuteGetMealByDifficultyOfCooking() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/flavor/łatwy"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealPreparation()")
    public void shouldExecuteGetMealPreparation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/1/preparation"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should not execute getMealPreparation()")
    public void shouldNotExecuteGetMealPreparation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/x/preparation"))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealProducts()")
    public void shouldExecuteGetMealProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/1/products"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should not execute getMealProducts()")
    public void shouldNotExecuteGetMealProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/x/products"))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getProductMeals()")
    public void shouldExecuteGetProductMeals() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/all/1"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should not execute getProductMeals()")
    public void shouldNotExecuteGetProductMeals() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/all/x"))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getSpiceMeals()")
    public void shouldExecuteGetSpiceMeals() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/notContains/sól"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should not execute getSpiceMeals()")
    public void shouldNotExecuteGetSpiceMeals() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/notContains/1/1"))
                .andExpect(MockMvcResultMatchers.status().is(404));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealWithNutrients()")
    public void shouldExecuteGetMealWithNutrients() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/contains/błonnik"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should not execute getMealWithNutrients()")
    public void shouldNotExecuteGetMealWithNutrients() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/contains/1/1"))
                .andExpect(MockMvcResultMatchers.status().is(404));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getMealHealthyProperty()")
    public void shouldExecuteGetMealHealthyProperty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/1/isHealthy"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should not execute getMealHealthyProperty()")
    public void shouldNotExecuteGetMealHealthyProperty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/x/isHealthy"))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getProteinMeals()")
    public void shouldExecuteGetProteinMeals() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/proteinMeals"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should not execute getProteinMeals()")
    public void shouldNotExecuteGetProteinMeals() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/protein"))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should execute getProteinMeals()")
    public void shouldExecuteGetMealById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/1"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should not execute getProteinMeals()")
    public void shouldNotExecuteGetMealById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/x"))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }
}
