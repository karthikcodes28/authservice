package com.karthik.auth.Controller;

import com.karthik.auth.Dto.APIResponse;
import com.karthik.auth.Dto.LoginRequest;
import com.karthik.auth.Dto.RegisterRequest;
import com.karthik.auth.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<APIResponse> registerUser(@RequestBody RegisterRequest registerRequest){
        authService.registerUser(registerRequest);
        return ResponseEntity.ok(new APIResponse("User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse>login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(new APIResponse(authService.loginUser(loginRequest)));
    }
}
