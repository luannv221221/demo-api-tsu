package com.ra.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseWrapper <T> {
    private HttpStatus status;
    private int code;
    private T data;
}
