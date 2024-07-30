package com.realworld.locationmanagementapi.repository;

import com.realworld.locationmanagementapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    public UserEntity findByEmailAndPassword(String username,String password);

    public UserEntity findByEmail(String email);
}
