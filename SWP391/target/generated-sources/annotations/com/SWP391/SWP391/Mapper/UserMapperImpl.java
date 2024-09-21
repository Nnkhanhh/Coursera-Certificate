package com.SWP391.SWP391.Mapper;

import com.SWP391.SWP391.DTO.Request.UserCreationRequest;
import com.SWP391.SWP391.DTO.Request.UserUpdateRequest;
import com.SWP391.SWP391.DTO.Response.UserResponse;
import com.SWP391.SWP391.Entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );
        user.setEmail( request.getEmail() );
        user.setRole( request.getRole() );
        user.setPhoneNumber( request.getPhoneNumber() );

        return user;
    }

    @Override
    public UserResponse toUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( user.getId() );
        userResponse.username( user.getUsername() );
        userResponse.password( user.getPassword() );
        userResponse.email( user.getEmail() );
        userResponse.role( user.getRole() );
        userResponse.phoneNumber( user.getPhoneNumber() );

        return userResponse.build();
    }

    @Override
    public void updateUser(User user, UserUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        user.setPassword( request.getPassword() );
        user.setEmail( request.getEmail() );
        user.setRole( request.getRole() );
        user.setPhoneNumber( request.getPhoneNumber() );
    }
}
