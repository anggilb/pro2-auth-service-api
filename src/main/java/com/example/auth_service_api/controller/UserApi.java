package com.example.auth_service_api.controller;

import com.example.auth_service_api.commons.constants.ApiPathConstants;
import com.example.auth_service_api.commons.dtos.UserRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.USER_ROUTE)
public interface UserApi {
    @GetMapping(value = "/get")
    ResponseEntity<UserDetails> getUser(
            HttpServletRequest request
    );

    @PutMapping(value = "/put")
    ResponseEntity<Void> putUser(
            HttpServletRequest request,
            @RequestBody UserRequest userRequest
    );

    @DeleteMapping(value = "/delete")
    ResponseEntity<Void> deleteUser(
            HttpServletRequest request
    );
}