package com.SWP391.SWP391.Controller;

import com.SWP391.SWP391.DTO.Request.ApiResponse;
import com.SWP391.SWP391.DTO.Request.AuthenticationRequest;
import com.SWP391.SWP391.DTO.Response.AuthenticationResponse;
import com.SWP391.SWP391.Service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
    Boolean result = authenticationService.authenticate(request);
    return ApiResponse.<AuthenticationResponse>builder()
            .result(AuthenticationResponse.builder()
                    .authenticated(result)
                    .build())
            .build();
    }



}
