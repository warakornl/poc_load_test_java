package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@Data
@ToString
public class RequestInsertDataRequestBody {

    private String log_id;
    private String user_name;
    private int age;
}
