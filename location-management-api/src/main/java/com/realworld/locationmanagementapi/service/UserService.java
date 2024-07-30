package com.realworld.locationmanagementapi.service;

import com.realworld.locationmanagementapi.exception.BusinessException;
import com.realworld.locationmanagementapi.exception.EmailAlreadyExistsException;
import com.realworld.locationmanagementapi.model.UserModel;
import org.springframework.stereotype.Service;


public interface UserService {

    public boolean login(UserModel userModel) throws BusinessException;

    public Long register(UserModel userModel) throws EmailAlreadyExistsException;
}
