package com.coding.exercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

@Validated
public class BalanceTestResult {
    @JsonProperty("input")
    @ApiModelProperty(example = "[]")
    private String input;

    @JsonProperty("isBalanced")
    @ApiModelProperty(example = "false")
    private Boolean isBalanced;

    public BalanceTestResult() {
        super();
    }

    public BalanceTestResult(String input, Boolean isBalanced) {
        this.input = input;
        this.isBalanced = isBalanced;
    }

    public String getInput() {
        return input;
    }

    public Boolean isIsBalanced() {
        return isBalanced;
    }

}

