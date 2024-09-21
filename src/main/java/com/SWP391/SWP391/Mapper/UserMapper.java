package com.SWP391.SWP391.Mapper;

import com.SWP391.SWP391.DTO.Request.UserCreationRequest;
import com.SWP391.SWP391.DTO.Request.UserUpdateRequest;
import com.SWP391.SWP391.DTO.Response.UserResponse;
import com.SWP391.SWP391.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

//Mapper Dùng tromng trường hợp :
//  user.setPassword(request.getPassword());
//        user.setPhoneNumber(request.getPhoneNumber());
//        user.setEmail(request.getEmail());
//        user.setRole(request.getRole());
//Giống nhau lặp lại


@Mapper(componentModel =  "spring" )
public interface UserMapper {
    //USER
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

}
