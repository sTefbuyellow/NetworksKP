package com.course.project.Fapi.service.interfaces;

import com.course.project.Fapi.entity.AuthenticationResponse;
import com.course.project.Fapi.entity.LoginRequest;
import com.course.project.Fapi.entity.RegisterRequest;

public interface AuthService {
    void signup(RegisterRequest registerRequest);
    AuthenticationResponse login(LoginRequest loginRequest);
}
