package com.SWP391.SWP391.Service;

import com.SWP391.SWP391.DTO.Request.AuthenticationRequest;
import com.SWP391.SWP391.Exception.AppException;
import com.SWP391.SWP391.Exception.ErrorCode;
import com.SWP391.SWP391.Repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    UserRepository userRepository;


    public boolean authenticate(AuthenticationRequest request){
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USERNAME_NOTEXISTED));
        // map pass user cung cấp với pass user tạo lúc đầu
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }

}
