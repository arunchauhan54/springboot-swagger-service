package com.coding.exercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

@Validated
public class BalanceTestResult {
    @JsonProperty("input")
    @ApiModelProperty(example = "[]", value = "")
    private final String input;

    @JsonProperty("isBalanced")
    @ApiModelProperty(example = "false", value = "")
    private final Boolean isBalanced;

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

