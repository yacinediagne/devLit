package com.practice.devLit;

import com.practice.devLit.model.Posts;
import com.practice.devLit.model.Subjects;
import com.practice.devLit.model.Users;
import com.practice.devLit.repository.PostsRepository;
import com.practice.devLit.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureJsonTesters
@SpringBootTest
@AutoConfigureMockMvc
public class PostsTestI {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private static PostsRepository postsRepository;

    @Autowired
    private static UsersRepository usersRepository;

    public Posts post ;
    public Users author;
    public Subjects subject;

    @Autowired
    private JacksonTester<Posts> postsJacksonTester;

    @BeforeEach
    public void initiateVariable(){

        Long id = 1L;
        author= new Users( 1L,false,LocalDate.now(), "adja@example.com", "adja" ,  "sy", "passer", LocalDate.now());
        subject= new Subjects(1, "adja@example.com", "adja");

        post = new Posts(LocalDate.now(),
                "This is a tutorial",
                "Deploying on Kubernetes ", LocalDate.now(),
                author, subject);
    }

    @Test
    //@WithMockUser("user@yopmail.com") // à Mettre si on a la securite dans notre appli avec un user qui existe
    void savePostsTest() throws Exception {
        mockMvc.perform(post("/save-posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postsJacksonTester.write(post).getJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Deploying on Kubernetes"))).andReturn().getResponse();
    }
    @Test
    void findByAuthorTest() throws Exception {
        mockMvc.perform(get("/posts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].title", is("Deploying on Kubernetes"))).andReturn().getResponse();
    }



}

