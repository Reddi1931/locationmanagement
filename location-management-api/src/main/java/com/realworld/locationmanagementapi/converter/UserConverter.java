package com.realworld.locationmanagementapi.converter;

import com.realworld.locationmanagementapi.entity.UserEntity;
import com.realworld.locationmanagementapi.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertToUserEntity(UserModel userModel){
        UserEntity userEntity=new UserEntity();
        userEntity.setEmail(userModel.getEmail());
        userEntity.setPassword(userModel.getPassword());
        userEntity.setMobileNumber(userModel.getMobileNumber());
        userEntity.setFullName(userModel.getFullName());

        return userEntity;
    }
}
