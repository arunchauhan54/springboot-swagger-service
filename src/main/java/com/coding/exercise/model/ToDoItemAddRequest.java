package com.coding.exercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;


@Validated
public class ToDoItemAddRequest {

    @JsonProperty("text")
    @ApiModelProperty(example = "Uulwi ifis halahs gag erh'ongg w'ssh.")
    @Size(min = 1, max = 50)
    private String text = null;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

