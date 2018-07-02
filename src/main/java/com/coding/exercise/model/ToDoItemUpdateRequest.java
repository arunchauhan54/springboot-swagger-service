package com.coding.exercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Validated
public class ToDoItemUpdateRequest {

    @JsonProperty("text")
    @ApiModelProperty(example = "Uulwi ifis halahs gag erh'ongg w'ssh.")
    @Size(min = 1, max = 50)
    private String text = null;

    @JsonProperty("isCompleted")
    @ApiModelProperty(example = "true")
    private Boolean isCompleted;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

}

