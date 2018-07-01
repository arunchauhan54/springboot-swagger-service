package com.coding.exercise.service;

import com.coding.exercise.model.ToDoItem;
import com.coding.exercise.model.ToDoItemAddRequest;
import com.coding.exercise.model.ToDoItemUpdateRequest;

import java.math.BigDecimal;

public interface ToDoService {

    ToDoItem save(ToDoItemAddRequest toDoItem);

    ToDoItem find(BigDecimal id);

    ToDoItem update(BigDecimal id, ToDoItemUpdateRequest request);
}
