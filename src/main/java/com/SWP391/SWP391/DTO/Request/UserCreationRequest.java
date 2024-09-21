package com.SWP391.SWP391.DTO.Request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Conditional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    @Size(min = 4, message = "Username must be at least 4 characters")
     String username;
    @Size(min = 6, message = "Password must be at least 6 characters")
     String password;
     String email;
     String role;
    @Size(max = 10, min = 10, message = "Phone numbers have  10 digits")
     String phoneNumber;


}
