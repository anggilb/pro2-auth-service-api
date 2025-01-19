package com.example.auth_service_api.controller.impl;

import com.example.auth_service_api.commons.dtos.UserRequest;
import com.example.auth_service_api.controller.UserApi;
import com.example.auth_service_api.service.impl.UserDetailsImpl;
import com.example.auth_service_api.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {
    private final UserDetailsImpl userDetails;
    private final UserServiceImpl userServiceImpl;

    public UserController(UserDetailsImpl userDetails, UserServiceImpl userServiceImpl) {
        this.userDetails = userDetails;
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public ResponseEntity<UserDetails> getUser(HttpServletRequest request) {
        Long userId = Long.valueOf((String) request.getAttribute("X-User-Id").toString());
        return ResponseEntity.ok(userDetails.loadUserById(userId));
    }

    @Override
    public ResponseEntity<Void> putUser(HttpServletRequest request, UserRequest userRequest) {
        Long userId = Long.valueOf((String) request.getAttribute("X-User-Id").toString());
        userServiceImpl.putUser(userId, userRequest);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(HttpServletRequest request) {
        Long userId = Long.valueOf((String) request.getAttribute("X-User-Id").toString());
        userServiceImpl.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}