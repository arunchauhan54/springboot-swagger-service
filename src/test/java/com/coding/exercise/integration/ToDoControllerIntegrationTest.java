package com.coding.exercise.integration;

import com.coding.exercise.model.ToDoItem;
import com.coding.exercise.model.ToDoItemAddRequest;
import com.coding.exercise.model.ToDoItemNotFoundError;
import com.coding.exercise.model.ToDoItemValidationError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToDoControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getToDo_shouldFailWithItemNotFoundError() {
        ResponseEntity<ToDoItemNotFoundError> responseEntity = restTemplate.getForEntity("/todo/1",
                ToDoItemNotFoundError.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(responseEntity.getBody().getName()).containsIgnoringCase("NotFound");
        assertThat(responseEntity.getBody().getDetails().size()).isEqualTo(1);
        assertThat(responseEntity.getBody().getDetails().get(0).getMessage())
                .containsIgnoringCase("Item with 1 not found");
    }

    @Test
    public void getToDo_shouldFailWithInvalidInputError() {
        ToDoItemAddRequest toDoItemAddRequest = new ToDoItemAddRequest();
        toDoItemAddRequest.setText(null);

        ResponseEntity<ToDoItemValidationError> responseEntity = restTemplate
                .postForEntity("/todo", toDoItemAddRequest, ToDoItemValidationError.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(responseEntity.getBody().getName()).isEqualToIgnoringCase("ValidationError");
    }

    @Test
    public void addToDo_shouldPass() {
        ResponseEntity<ToDoItem> toDoItemResponse = addTodo("A todo note!");

        assertThat(toDoItemResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(toDoItemResponse.getBody().getText()).isEqualTo("A todo note!");
        assertThat(toDoItemResponse.getBody().getId()).isNotNull();
        assertThat(toDoItemResponse.getBody().isIsCompleted()).isFalse();
    }

    private ResponseEntity<ToDoItem> addTodo(String note) {
        ToDoItemAddRequest toDoItemAddRequest = new ToDoItemAddRequest();
        toDoItemAddRequest.setText(note);
        return restTemplate
                .postForEntity("/todo", toDoItemAddRequest, ToDoItem.class);
    }

    @Test
    public void addToDoAndGet_shouldPass() {
        ResponseEntity<ToDoItem> toDoItemResponse = addTodo("A todo note!");
        BigDecimal id = toDoItemResponse.getBody().getId();

        ResponseEntity<ToDoItem> toDoItemSearchResponse = restTemplate.getForEntity("/todo/" + id, ToDoItem.class);

        assertThat(toDoItemSearchResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(toDoItemSearchResponse.getBody().getText()).isEqualTo("A todo note!");
        assertThat(toDoItemSearchResponse.getBody().getId()).isNotNull();
        assertThat(toDoItemSearchResponse.getBody().isIsCompleted()).isFalse();
    }

}
