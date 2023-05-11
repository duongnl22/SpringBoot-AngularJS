package com.example.duongnl_assignment_java4.exception;

import com.example.duongnl_assignment_java4.request.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private HttpStatus status ;

    private String message ;

    private List<String> listMessage;
}
