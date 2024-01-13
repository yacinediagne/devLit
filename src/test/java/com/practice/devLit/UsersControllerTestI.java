package com.practice.devLit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.devLit.model.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerTestI {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    Users user;
    private long id ;
    @BeforeEach
    public void start() {
        System.out.println("Starting Tests");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        LocalDate localDate = LocalDate.now();
        user= new Users( (long)7,false,localDate, "adja@example.com", "adja" ,  "sy", "passer", localDate);
        //Users user= new Users((long)1, false,"16-12-2023", "fatoumata@example.com", "fatoumata" ,  "deme", "passer", "16-12-2023");
        //"This is my favorite topic", "Why Kubernetes", "16-12-2023", "Yacine", "Devops" );
        id = 1;
    }



    @Test
    public void getUserTest() throws Exception {
        mockMvc.perform(get("/users/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is("amy@example.com")));

    }

    @Test
    public void getUsersTest() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[1].email", is("fatoumata@example.com")));

    }

    @Test
    public void saveUserTest() throws Exception {
//        String json = "{" +
//                "\"createdAt\": \"20-20-2023\"," +
//                "\"email\": \"amy@example.com\"," +
//                "\"firstName\": \"mariam\"," +
//                "\"lastName\": \"diagne\"," +
//                "\"password\": \"passer\"," +
//                "\"updatedAt\": \"20-20-2023\"" +
//                "}";
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Adja"))
                .andExpect(jsonPath("$.email").value("adja@example.com"));
    }

    @Test
    public void deleteUserTest() throws Exception {
        mockMvc.perform(delete("/delete-user/{id}", id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


 
}

    