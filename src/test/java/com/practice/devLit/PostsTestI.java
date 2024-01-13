package com.practice.devLit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.practice.devLit.model.Messages;
import com.practice.devLit.model.Posts;
import com.practice.devLit.model.Subjects;
import com.practice.devLit.model.Users;
import com.practice.devLit.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PostsTestI {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UsersService usersService;

    Posts post ;
    Users author, user ;
    Subjects subject;
    List<Messages> messagesList = new ArrayList<>();
    Messages m1;
    Messages m2;
    private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());


    @BeforeEach
    public void initiateVariable(){

        LocalDate localDate = LocalDate.now();
        author= new Users( (long)1,false,localDate, "arame@example.com", "Arame" ,  "Ba", "passer", localDate);
        usersService.saveUserByCapitalize(author);
        user= new Users( (long)2,false,localDate, "mahmout@example.com", "mahmout" ,  "watt", "passer", localDate);
        usersService.saveUserByCapitalize(user);
        subject = new Subjects("This subject is about devops", "Devops");
        m1= new Messages(localDate, "very interesting", post, author );
        m2= new Messages(localDate, "Here we go", post, user);
        messagesList.add(m1);
        messagesList.add(m2);
        System.out.println(messagesList);
        post = new Posts(localDate, "This is a tutorial of how to deplay a java app on Kubernetes", "Deploying on Kubernetes ", localDate, author, subject, messagesList);
        System.out.println(post);
    }

    @Test
    public void findByAuthorTest() throws Exception {
        mockMvc.perform(get("/posts/{author}", author))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].title", is("Deploying on Kubernetes")));
    }

    @Test
    public void savePostsTest() throws Exception {
        mockMvc.perform(post("/save-posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Deploying on Kubernetes")));
    }

}

