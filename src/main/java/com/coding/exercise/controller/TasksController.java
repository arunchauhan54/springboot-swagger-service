package com.coding.exercise.controller;

import com.coding.exercise.model.BalanceTestResult;
import com.coding.exercise.model.ToDoItemValidationError;
import com.coding.exercise.util.BalancedBracket;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Validated
@RestController
@Api(tags = "tasks", description = "General algorithmic tasks")
public class TasksController {

    @ApiOperation(value = "Checks if brackets in a string are balanced", nickname = "tasksValidateBracketsGet",
            response = BalanceTestResult.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = BalanceTestResult.class),
            @ApiResponse(code = 400, message = "Validation error", response = ToDoItemValidationError.class)})
    @RequestMapping(value = "/tasks/validateBrackets",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<BalanceTestResult> tasksValidateBracketsGet(@Valid @Size(min = 1, max = 50)
                                                               @ApiParam(value = "Input string (max length 50)")
                                                               @RequestParam(value = "input") String input) {
        return new ResponseEntity<>(BalancedBracket.isBalancedBrackets(input), HttpStatus.OK);
    }

}
