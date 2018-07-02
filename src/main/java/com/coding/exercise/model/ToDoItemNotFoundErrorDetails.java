package com.coding.exercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;


@Validated
public class ToDoItemNotFoundErrorDetails {

    @JsonProperty("message")
    @ApiModelProperty(example = "Item with 9 not found")
    private String message;

    public ToDoItemNotFoundErrorDetails() {
        super();
    }

    public ToDoItemNotFoundErrorDetails(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}

