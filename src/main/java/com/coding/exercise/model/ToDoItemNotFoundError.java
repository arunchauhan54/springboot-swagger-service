package com.coding.exercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public class ToDoItemNotFoundError {
    @JsonProperty("details")
    @Valid
    private final List<ToDoItemNotFoundErrorDetails> details;

    @JsonProperty("name")
    @ApiModelProperty(example = "NotFoundError")
    private final String name;

    public ToDoItemNotFoundError(@Valid List<ToDoItemNotFoundErrorDetails> details, String name) {
        this.details = details;
        this.name = name;
    }

    public List<ToDoItemNotFoundErrorDetails> getDetails() {
        return details;
    }

    public String getName() {
        return name;
    }

}
