package com.coding.exercise.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TasksController.class)
public class TasksControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void tasksValidateBracketsGet() throws Exception {
        mvc.perform(get("/tasks/validateBrackets?input={}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("input", Matchers.is("{}")))
                .andExpect(jsonPath("isBalanced", Matchers.is(true)));

    }

}