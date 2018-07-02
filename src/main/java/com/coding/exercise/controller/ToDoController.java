package com.coding.exercise.controller;

import com.coding.exercise.model.*;
import com.coding.exercise.service.ToDoService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController()
@Api(tags = "todo", description = "To Do List endpoints")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @ApiOperation(value = "Retrieve a specific item by id", response = ToDoItem.class, protocols = "http,https")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ToDoItem.class),
            @ApiResponse(code = 400, message = "Validation error", response = ToDoItemValidationError.class),
            @ApiResponse(code = 404, message = "Not Found Error", response = ToDoItemNotFoundError.class)})
    @GetMapping(value = "/todo/{id}", produces = {"application/json"})
    public ResponseEntity<ToDoItem> getToDo(@PathVariable() BigDecimal id) {
        return new ResponseEntity<>(toDoService.find(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create a to do item", response = ToDoItem.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ToDoItem.class),
            @ApiResponse(code = 400, message = "Validation error", response = ToDoItemValidationError.class)})
    @PostMapping(value = "/todo",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<ToDoItem> saveToDo(@ApiParam(required = true) @Valid @RequestBody ToDoItemAddRequest body) {
        return new ResponseEntity<>(toDoService.save(body), HttpStatus.OK);
    }


    @ApiOperation(value = "Modify an item", response = ToDoItem.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ToDoItem.class),
            @ApiResponse(code = 400, message = "Validation error", response = ToDoItemValidationError.class),
            @ApiResponse(code = 404, message = "Not Found Error", response = ToDoItemNotFoundError.class)})
    @PatchMapping(value = "/todo/{id}",
            produces = {"application/json"},
            consumes = {"application/json"})
    ResponseEntity<ToDoItem> patchToDo(@ApiParam(required = true) @PathVariable() BigDecimal id,
                                       @ApiParam(required = true) @Valid @RequestBody ToDoItemUpdateRequest request) {
        return new ResponseEntity<>(toDoService.update(id, request), HttpStatus.OK);
    }


}
