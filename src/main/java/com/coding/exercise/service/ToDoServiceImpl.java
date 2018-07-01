package com.coding.exercise.service;

import com.coding.exercise.exception.NotFoundException;
import com.coding.exercise.model.ToDoItem;
import com.coding.exercise.model.ToDoItemAddRequest;
import com.coding.exercise.model.ToDoItemUpdateRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public ToDoItem save(ToDoItemAddRequest request) {
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setText(request.getText());
        toDoItem.setIsCompleted(false);
        toDoItem.setCreatedAt(new Date());
        return toDoRepository.save(toDoItem);
    }

    @Override
    public ToDoItem find(BigDecimal id) {
        return toDoRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Item with " + id + " not found")
                );
    }

    @Override
    public ToDoItem update(BigDecimal id, ToDoItemUpdateRequest request) {
        ToDoItem toDoItem = find(id);
        toDoItem.setText(request.getText());
        toDoItem.setIsCompleted(request.isIsCompleted());
        return toDoRepository.save(toDoItem);
    }
}
