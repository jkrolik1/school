package com.diethelper.db.diethelperdb.IntegrationTests;

import com.diethelper.db.diethelperdb.service.DBFileStorageService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FilesIntegrationTests {

    private final String username = "test";
    private final String password = "test";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DBFileStorageService dbFileStorageService;

    @Test
    @WithMockUser(value = username, password = password)
    @DisplayName("Should upload single file")
    public void shouldUploadSingleFile() throws Exception {

        MockMultipartFile mmpf = new MockMultipartFile(
                "file",
                "test-file.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "qwerty".getBytes());

        this.mockMvc.perform(multipart("/uploadFile").file(mmpf))
                .andExpect(status().isOk());
    }
}
