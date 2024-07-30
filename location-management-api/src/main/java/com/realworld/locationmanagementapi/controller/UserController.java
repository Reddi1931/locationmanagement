package com.realworld.locationmanagementapi.controller;

import com.realworld.locationmanagementapi.exception.BusinessException;
import com.realworld.locationmanagementapi.exception.EmailAlreadyExistsException;
import com.realworld.locationmanagementapi.exception.MethodArgumentNotValidException;
import com.realworld.locationmanagementapi.model.UserModel;
import com.realworld.locationmanagementapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody UserModel userModel) throws BusinessException {
        boolean result=userService.login(userModel);
        if(result){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(result,HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody @Valid UserModel userModel, BindingResult bindingResult) throws EmailAlreadyExistsException, MethodArgumentNotValidException {
        if(bindingResult.hasErrors()) throw new MethodArgumentNotValidException(bindingResult);
       Long savedUserId=userService.register(userModel);
       return new ResponseEntity<>(savedUserId,HttpStatus.CREATED);
    }
}
