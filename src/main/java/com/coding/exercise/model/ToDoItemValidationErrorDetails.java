package com.coding.exercise.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

@Validated
public class ToDoItemValidationErrorDetails {
    @ApiModelProperty(example = "params")
    private String location;

    @ApiModelProperty(example = "text")
    private String param;

    @ApiModelProperty(example = "Must be between 1 and 50 chars long")
    private String msg;

    @ApiModelProperty(example = "input value")
    private String value;

    public ToDoItemValidationErrorDetails() {
        super();
    }

    public ToDoItemValidationErrorDetails(String location, String param, String msg, String value) {
        this.location = location;
        this.param = param;
        this.msg = msg;
        this.value = value;
    }

    public String getLocation() {
        return location;
    }

    public String getParam() {
        return param;
    }

    public String getMsg() {
        return msg;
    }

    public String getValue() {
        return value;
    }
}

