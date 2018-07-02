package com.coding.exercise.controller;

import com.coding.exercise.model.ToDoItem;
import com.coding.exercise.model.ToDoItemAddRequest;
import com.coding.exercise.service.ToDoRepository;
import com.coding.exercise.service.ToDoService;
import com.coding.exercise.service.ToDoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ToDoController.class)
public class ToDoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ToDoRepository toDoRepository;

    private ToDoItem toDoItem;

    @Before
    public void setUp() {
        toDoItem = new ToDoItem();
        toDoItem.setText("Hello_from_TodoService!");
        toDoItem.setIsCompleted(false);
        toDoItem.setId(BigDecimal.valueOf(1));

        when(toDoRepository.save(any()))
                .thenAnswer(invocation -> invocation.getArgument(0));

        when(toDoRepository.findById(BigDecimal.ZERO))
                .thenReturn(Optional.empty());

        when(toDoRepository.findById(BigDecimal.ONE))
                .thenReturn(Optional.of(toDoItem));

    }

    @Test
    public void getToDo() throws Exception {
        ToDoItemAddRequest toDoItemAddRequest = new ToDoItemAddRequest();
        toDoItemAddRequest.setText("A todo note!");

        mvc.perform(get("/todo/" + BigDecimal.ONE)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    /*
     * Provides configuration for this test case. Repository is being mocked.
     */
    @TestConfiguration
    static class ToDoServiceTestContextConfiguration {

        @MockBean
        private ToDoRepository toDoRepository;

        @Bean
        public ToDoService toDoService() {
            return new ToDoServiceImpl(toDoRepository);
        }
    }
}