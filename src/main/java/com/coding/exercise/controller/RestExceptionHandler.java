package com.coding.exercise.controller;

import com.coding.exercise.exception.NotFoundException;
import com.coding.exercise.exception.ValidationException;
import com.coding.exercise.model.ToDoItemNotFoundError;
import com.coding.exercise.model.ToDoItemNotFoundErrorDetails;
import com.coding.exercise.model.ToDoItemValidationError;
import com.coding.exercise.model.ToDoItemValidationErrorDetails;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ToDoItemNotFoundError> handleItemNotFound(NotFoundException ex) {
        ToDoItemNotFoundErrorDetails details = new ToDoItemNotFoundErrorDetails(ex.getMessage());
        ToDoItemNotFoundError error = new ToDoItemNotFoundError(Arrays.asList(details), "NotFoundError");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ToDoItemValidationError> handleItemNotFound(ValidationException ex) {
        ToDoItemValidationErrorDetails details = new ToDoItemValidationErrorDetails("", "", "", ex.getMessage());
        ToDoItemValidationError error = new ToDoItemValidationError(Arrays.asList(details), "ValidationError");
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ToDoItemValidationErrorDetails> details;
        details = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(objectError -> (FieldError) objectError)
                .map(fieldError -> new ToDoItemValidationErrorDetails("param", fieldError.getField(),
                        fieldError.getDefaultMessage(), (String) fieldError.getRejectedValue())
                ).collect(Collectors.toList());
        ToDoItemValidationError error = new ToDoItemValidationError(details, "ValidationError");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<ToDoItemValidationError> handleResourceNotFoundException(ConstraintViolationException e) {
        List<ToDoItemValidationErrorDetails> details = e.getConstraintViolations()
                .stream()
                .map(violation ->
                        new ToDoItemValidationErrorDetails("param",
                                ((PathImpl) violation.getPropertyPath()).getLeafNode().getName(),
                                violation.getMessage(), violation.getInvalidValue().toString())
                ).collect(Collectors.toList());

        ToDoItemValidationError error = new ToDoItemValidationError(details, "ValidationError");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
