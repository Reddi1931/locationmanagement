package com.realworld.locationmanagementapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {

    @NotNull(message = "full name cannot be empty")
    private String fullName;

    @NotNull(message = "email cannot be empty")
    @Email(message = "Invalid Email")
    private String email;

    @NotNull(message = "password cannot be empty")
    @Size(min=8,message = "password should be atleast 8 characters of length")
    private String password;

    @NotNull(message = "phone number should not be empty")
    @Size(min = 10,max = 13,message = "mobile number should be of 10-13 characters in length")
    private String mobileNumber;
}
