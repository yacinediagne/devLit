package com.practice.devLit;

import com.practice.devLit.controller.SubjectsController;
import com.practice.devLit.model.Posts;
import com.practice.devLit.model.Subjects;
import com.practice.devLit.model.Users;
import com.practice.devLit.repository.PostsRepository;
import com.practice.devLit.repository.SubjectsRepository;
import com.practice.devLit.repository.UsersRepository;
import com.practice.devLit.service.UsersService;
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
public class PostsTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private static PostsRepository postsRepository;

    @Autowired
    private static UsersRepository usersRepository;

    public Posts post ;
    public Users author1;
    public Subjects subject;

    @Autowired
    private JacksonTester<Posts> postsJacksonTester;
    @Autowired
    private UsersService usersService;

    @Autowired
    private SubjectsController subjectsController;


    @BeforeEach
    public void start(){
        System.out.println("We are in the starting section of the test");
        Long id = 5L;
        author1= new Users( false,LocalDate.now(), "yacine@example.com", "yacine" ,  "diagne", "passer", LocalDate.now());
        usersService.saveUserByCapitalize(author1);
        System.out.println(author1);
        subject= new Subjects("Linux commande line guide", "Know your Linux CL");
        subjectsController.saveSubject(subject);
        post = new Posts(LocalDate.now(),
                "This is a tutorial",
                "Deploying on Kubernetes ",LocalDate.now(), author1, subject);
        System.out.println(post);
    }
    //@MENDEL-BA le test savePostsTest ne marche toujours pas j'ai une erreur 500 cette fois

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

