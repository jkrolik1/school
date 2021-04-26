package com.diethelper.db.diethelperdb.TestResources;

import com.diethelper.db.diethelperdb.model.Meal;
import com.diethelper.db.diethelperdb.repository.MealRepository;
import com.diethelper.db.diethelperdb.resource.MealResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class MealTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MealResource mealResource;

    @Autowired
    private MealRepository mealRepository;

    @Test
    @DisplayName("Should get single meal")
    public void getSingleMealTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mealId", Matchers.is(1)));
    }

    @Test
    @DisplayName("Should check meal")
    public void getSingleMeal2Test() throws Exception {
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/meal/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

        Meal meal = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),Meal.class);

        assertThat(meal).isNotNull();
        assertThat(meal.getMealId()).isEqualTo(1);
        assertThat(meal.getName()).isNotNull();
        assertThat(meal.getName()).isNotEmpty();
    }

    @Test
    @DisplayName("Should check meals list")
    public void getMealsTest() throws Exception {
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/meal/all"))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().is(200))
                        .andReturn();

        List<Meal> meals = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Meal.class));

        int size = mealResource.getAll().size();

        assertThat(meals).isNotNull();
        assertThat(meals.size()).isGreaterThan(0);
        assertThat(meals.size()).isEqualTo(size);
    }
    
}
