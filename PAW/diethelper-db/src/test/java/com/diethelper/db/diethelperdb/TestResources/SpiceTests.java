package com.diethelper.db.diethelperdb.TestResources;

import com.diethelper.db.diethelperdb.model.Nutrients;
import com.diethelper.db.diethelperdb.model.Spice;
import com.diethelper.db.diethelperdb.repository.NutrientsRepository;
import com.diethelper.db.diethelperdb.repository.SpiceRepository;
import com.diethelper.db.diethelperdb.resource.NutrientsResource;
import com.diethelper.db.diethelperdb.resource.SpiceResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.plugin2.util.PojoUtil.toJson;

@SpringBootTest
@AutoConfigureMockMvc
public class SpiceTests {
    private final String username = "test";
    private final String password = "test";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SpiceResource spiceResource;

    @Autowired
    private SpiceRepository spiceRepository;

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Check if post method works well")
    public void checkSpicePost() throws Exception {
        Spice spice = new Spice(0,"test");

        mockMvc.perform(post("/spice/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(spice)))
                .andExpect(status().isOk());
    }

    @WithMockUser(value = username, password = password)
    @Test
    @DisplayName("Check delete method on every test spice")
    public void checkSpiceDelete() throws Exception {
        List<Spice> spicesce = new ArrayList<>(spiceRepository.findAll());

        for (int i = 0; i < spicesce.size(); ++i)
            if (spicesce.get(i).getName().equals("test"))
                mockMvc.perform(MockMvcRequestBuilders
                        .delete("/nutrients/" + spicesce.get(i).getName() + ""))
                        .andExpect(MockMvcResultMatchers.status().is(200));
    }
}
