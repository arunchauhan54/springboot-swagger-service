package com.coding.exercise.service;

import com.coding.exercise.model.ToDoItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ToDoRepositoryTest {

    @Autowired
    private ToDoRepository toDoRepository;

    @Before
    public void setup() {

    }

    @Test
    public void save() {
        String hello_from_save = "Hello_from_save";
        ToDoItem toDoItem = createToDoForText(hello_from_save);

        ToDoItem returnItem = toDoRepository.save(toDoItem);

        assertThat(hello_from_save).isEqualTo(returnItem.getText());
        assertThat(returnItem.isIsCompleted()).isFalse();
    }


    @Test
    public void findById() {
        String hello_from_find = "Hello_from_find";
        ToDoItem toDoItem = createToDoForText(hello_from_find);
        toDoItem = toDoRepository.save(toDoItem);

        Optional<ToDoItem> returnItem = toDoRepository.findById(toDoItem.getId());

        assertThat(returnItem.isPresent()).isTrue();
        assertThat(hello_from_find).isEqualTo(returnItem.get().getText());
    }

    private ToDoItem createToDoForText(String hello_from_save) {
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setIsCompleted(false);
        toDoItem.setCreatedAt(new Date());
        toDoItem.setText(hello_from_save);
        return toDoItem;
    }

}