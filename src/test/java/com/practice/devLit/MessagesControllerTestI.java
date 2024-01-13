package com.practice.devLit;

import com.practice.devLit.model.Messages;
import com.practice.devLit.model.Posts;
import com.practice.devLit.model.Users;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class MessagesControllerTestI {

    @Autowired
    private MockMvc mockMvc;
    Messages messages;
    Users author;
    LocalDate localDate;
    String message;
    @BeforeEach
    public void initVar(){
        localDate= LocalDate.now();
        message = "Very interresting subject";
        author= new Users( (long)1,false,localDate, "arame@example.com", "Arame" ,  "Ba", "passer", localDate);
//        messages = Messages(localDate , message, Posts post, Users user)

    }
    public void sendMessagesTest(){

    }
}
