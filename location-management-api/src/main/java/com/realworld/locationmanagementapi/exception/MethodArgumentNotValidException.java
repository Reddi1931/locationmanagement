package com.realworld.locationmanagementapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.BindingResult;

@AllArgsConstructor
@Data
public class MethodArgumentNotValidException extends Exception{
    private BindingResult bindingResult;
}
