package com.diethelper.db.diethelperdb.TestResources;

import com.diethelper.db.diethelperdb.model.Meal;
import com.diethelper.db.diethelperdb.model.Product;
import com.diethelper.db.diethelperdb.repository.MealRepository;
import com.diethelper.db.diethelperdb.resource.MealResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.plugin2.util.PojoUtil.toJson;

@SpringBootTest
@AutoConfigureMockMvc
public class MealTests {

    private final String username = "test";
    private final String password = "test";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MealResource mealResource;

    @Autowired
    private MealRepository mealRepository;

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should get single meal")
    public void getSingleMealTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/meal/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mealId", Matchers.is(1)));
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should check meal")
    public void getSingleMeal2Test() throws Exception {
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/meal/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is(200))
                .andReturn();

        Meal meal = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),Meal.class);

        assertThat(meal).isNotNull();
        assertThat(meal.getMealId()).isEqualTo(1);
        assertThat(meal.getName()).isNotNull();
        assertThat(meal.getName()).isNotEmpty();
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Should check meals list")
    public void getMealsTest() throws Exception {
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/meal/all"))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(status().is(200))
                        .andReturn();

        List<Meal> meals = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Meal.class));

        int size = mealResource.getAll().size();

        assertThat(meals).isNotNull();
        assertThat(meals.size()).isGreaterThan(0);
        assertThat(meals.size()).isEqualTo(size);
    }

    @Test
    @DisplayName("Should check if every meal includes name")
    public void checkMealsNames() throws Exception {
        List<Meal> meals = mealResource.getAll();
        boolean empty = false;

        for (int i = 0; i < meals.size(); ++i) {
            if (meals.get(i).getName().isEmpty()) {
                empty = true;
                break;
            }
        }

        assertThat(empty).isFalse();
    }

    @Test
    @DisplayName("Should check if meal ids for all meals are unique")
    public void checkMealsIds() throws Exception {
        List<Meal> meals = mealResource.getAll();
        Set<Integer> treeSet = new TreeSet<>();
        List<Integer> mealsId = new ArrayList<>();

        boolean empty = false;

        for (int i = 0; i < meals.size(); ++i) {
            mealsId.add(meals.get(i).getMealId());
            treeSet.add(meals.get(i).getMealId());
        }

        assertThat(mealsId.size()).isEqualTo(treeSet.size());
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Check if every meal contains at least one product")
    public void checkMealProducts() throws Exception {
        List<Meal> meals = mealResource.getAll();
        MvcResult mvcResult;
        List<Product> products;
        boolean end = false;

        for (int i = 0; i < meals.size(); ++i) {
            mvcResult = mockMvc.perform(MockMvcRequestBuilders
                    .get("/meal/"+meals.get(i).getMealId()+"/products"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().is(200))
                    .andReturn();
            products = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));

            if (products.size() < 1){
                end = true;
                break;
            }
        }
        assertThat(end).isFalse();
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Check if post method works well")
    public void checkMealPost() throws Exception {
        Meal meal = new Meal(100,"test","","","",0,0,0,0,0,"");

        mockMvc.perform(post("/meal/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(meal)))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Check delete method on every test meal")
    public void checkMealDelete() throws Exception {
        List<Meal> meals = new ArrayList<>(mealRepository.findAll());

        for (int i = 0; i < meals.size(); ++i)
            if (meals.get(i).getName().equals("test"))
                mockMvc.perform(MockMvcRequestBuilders
                        .delete("/meal/" + meals.get(i).getMealId() + ""))
                        .andExpect(MockMvcResultMatchers.status().is(200));
    }

}
