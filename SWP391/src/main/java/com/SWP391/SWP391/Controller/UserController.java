package com.SWP391.SWP391.Controller;

import com.SWP391.SWP391.DTO.Request.ApiResponse;
import com.SWP391.SWP391.DTO.Request.UserCreationRequest;
import com.SWP391.SWP391.DTO.Request.UserUpdateRequest;
import com.SWP391.SWP391.DTO.Response.UserResponse;
import com.SWP391.SWP391.Entity.User;
import com.SWP391.SWP391.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired // Tương tác với các class khác
    private UserService userService;


    //CREATE USER
    @PostMapping
//    User createUser(@RequestBody @Valid UserCreationRequest request){
//     return userService.createUser(request);
//    }

    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }
    //Get List Users
    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }
    //Get User By ID
    @GetMapping("/{userID}")
    UserResponse getUser(@PathVariable("userID") String userID){
        return userService.getUser(userID);
    }
    //Update User
    @PutMapping("/{userID}")
    UserResponse updateUser(@PathVariable("userID") String userID, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userID, request);
    }
    //Delete User
    @DeleteMapping("/{userID}")
    String deleteUser(@PathVariable("userID") String userID){
        userService.deleteUser(userID);
        return "User has been deleted";
    }
}
