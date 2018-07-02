package com.coding.exercise.service;

import com.coding.exercise.exception.NotFoundException;
import com.coding.exercise.model.ToDoItem;
import com.coding.exercise.model.ToDoItemAddRequest;
import com.coding.exercise.model.ToDoItemUpdateRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ToDoServiceImplTest {

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private ToDoRepository toDoRepository;

    private ToDoItem toDoItem;

    @Before
    public void setUp() {
        toDoItem = new ToDoItem();
        toDoItem.setText("Hello_from_TodoService");
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
    public void saveValid() {
        ToDoItemAddRequest toDoItemAddRequest = new ToDoItemAddRequest();
        toDoItemAddRequest.setText("Testing save method of todoService");

        ToDoItem toDoItem = toDoService.save(toDoItemAddRequest);

        assertThat(toDoItem.getText()).isEqualTo(toDoItemAddRequest.getText());
        assertThat(toDoItem.isIsCompleted()).isFalse();
        assertThat(toDoItem.getCreatedAt()).isNotNull();
    }

    @Test
    public void findValidId() {
        ToDoItem returnItem = toDoService.find(BigDecimal.ONE);
        assertThat(returnItem.getText()).isEqualTo(toDoItem.getText());
    }

    @Test(expected = NotFoundException.class)
    public void findForInvalidId() {
        toDoService.find(BigDecimal.ZERO);
    }

    @Test
    public void update() {
        ToDoItemUpdateRequest toDoItemAddRequest = new ToDoItemUpdateRequest();
        toDoItemAddRequest.setText("Testing update method of todoService");
        toDoItemAddRequest.setIsCompleted(true);

        ToDoItem toDoItem = toDoService.update(BigDecimal.ONE, toDoItemAddRequest);

        assertThat(toDoItem.getText()).isEqualTo(toDoItemAddRequest.getText());
        assertThat(toDoItem.isIsCompleted()).isTrue();
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

