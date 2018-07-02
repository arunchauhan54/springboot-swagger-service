package com.coding.exercise.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Validated
@Entity
public class ToDoItem implements Serializable {

    @Id
    @SequenceGenerator(name = "todo_generator", sequenceName = "todo_sequence", initialValue = 100)
    @GeneratedValue(generator = "todo_generator")
    private BigDecimal id = null;

    @Column
    @ApiModelProperty(example = "Uulwi ifis halahs gag erh'ongg w'ssh.")
    @NotNull
    private String text = null;

    @Column
    @ApiModelProperty(example = "false")
    private boolean isCompleted;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @ApiModelProperty(example = "2017-10-13T01:50:58.735Z")
    private Date createdAt = null;

    @ApiModelProperty(example = "42.0")
    @Valid
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}

