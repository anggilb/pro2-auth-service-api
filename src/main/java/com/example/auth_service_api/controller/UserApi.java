package com.example.auth_service_api.controller;

import com.example.auth_service_api.commons.constants.ApiPathConstants;
import com.example.auth_service_api.commons.dtos.UserRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.USER_ROUTE)
public interface UserApi {
    @SecurityRequirement(name = "Bearer Authorization")
    @GetMapping(value = "/get")
    ResponseEntity<UserDetails> getUser(
            @RequestAttribute("X-User-Id") Long userId
    );

    @SecurityRequirement(name = "Bearer Authorization")
    @PutMapping(value = "/put")
    ResponseEntity<Void> putUser(
            @RequestAttribute("X-User-Id") Long userId,
            @RequestBody UserRequest userRequest
    );

    @SecurityRequirement(name = "Bearer Authorization")
    @DeleteMapping(value = "/delete")
    ResponseEntity<Void> deleteUser(
            @RequestAttribute("X-User-Id") Long userId
    );
}