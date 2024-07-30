package com.realworld.locationmanagementapi.service;

import com.realworld.locationmanagementapi.constants.ErrorType;
import com.realworld.locationmanagementapi.converter.UserConverter;
import com.realworld.locationmanagementapi.entity.UserEntity;
import com.realworld.locationmanagementapi.exception.BusinessException;
import com.realworld.locationmanagementapi.exception.EmailAlreadyExistsException;
import com.realworld.locationmanagementapi.exception.ErrorModel;
import com.realworld.locationmanagementapi.model.UserModel;
import com.realworld.locationmanagementapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    @Override
    public boolean login(UserModel userModel) throws BusinessException {
        boolean result=false;
        UserEntity userEntity=userRepository.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
        if(userEntity==null)throw new BusinessException();
        result=true;
        return result;
    }

    @Override
    public Long register(UserModel userModel) throws EmailAlreadyExistsException {
        UserEntity ExisteduserEntity=userRepository.findByEmail(userModel.getEmail());
        if(ExisteduserEntity!=null)
            throw new EmailAlreadyExistsException();
        UserEntity userEntity=userConverter.convertToUserEntity(userModel);
        UserEntity savedUserEntity=userRepository.save(userEntity);
        return savedUserEntity.getId();
    }
}
