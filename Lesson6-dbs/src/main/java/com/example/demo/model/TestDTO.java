package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TestDTO {
    private String name;
    private Date year;
    private String authorName;
    private Integer page = 0;
}
