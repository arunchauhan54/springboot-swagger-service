package com.coding.exercise.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;


@Validated
public class ToDoItemValidationError {
    @Valid
    private List<ToDoItemValidationErrorDetails> details;

    @ApiModelProperty(example = "ValidationError")
    private String name;

    public ToDoItemValidationError() {
        super();
    }

    public ToDoItemValidationError(@Valid List<ToDoItemValidationErrorDetails> details, String name) {
        this.details = details;
        this.name = name;
    }

    public List<ToDoItemValidationErrorDetails> getDetails() {
        return details;
    }


    public String getName() {
        return name;
    }


}

