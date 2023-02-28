package com.example.codegenerator.error;

import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice(
        basePackages = "com.example.codegenerator",
        annotations = {
                RestController.class
        }
)
public class AdviceController {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public String onConstraintValidationException(ConstraintViolationException e) {
        return e.getMessage();
    }
}
