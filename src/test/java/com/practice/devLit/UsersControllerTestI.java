package com.practice.devLit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerTestI {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void start() {
        System.out.println("Starting Tests");
        // private Users user= Users(1, "16-12-2023", "This is my favorite topic", "Why
        // Kubernetes", "16-12-2023", "Yacine", "Devops" );
        // int id = 1;
    }

    private long id = 1;
    @Test
    public void getUserTest() throws Exception {
        mockMvc.perform(get("/users/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is("admindatabase@example.com")));

    }
}

    