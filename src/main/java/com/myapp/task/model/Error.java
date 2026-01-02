package com.myapp.task.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Error {

    private String error;

    private String description;

    private Integer status;

    private LocalDateTime date;

}
