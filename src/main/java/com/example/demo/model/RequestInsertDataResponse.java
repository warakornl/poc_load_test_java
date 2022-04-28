package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestInsertDataResponse implements Serializable {
    @NonNull
    private com.example.demo.model.RequestInsertDataResponse status;
}
