package com.coding.exercise.service;

import com.coding.exercise.model.ToDoItem;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface ToDoRepository extends CrudRepository<ToDoItem, BigDecimal> {
}
