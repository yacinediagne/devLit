package com.practice.devLit;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.practice.devLit.model.Subjects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc

public class SubjectsControllersTestI {

    @Autowired
    private MockMvc mockMvc;

    Subjects subject;
    int id;
    @BeforeEach
    public void variableTest(){
        subject = new Subjects();
        id=1;
    }
    @Test
    public void getSubjectsTest() throws Exception {

        mockMvc.perform(get("/subjects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].subject_id", is(1)));
    }

    @Test
    public void getSubjectTest() throws Exception{

        mockMvc.perform(get("/subject/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Science")));
    }



}
