package com.SWP391.SWP391.Service;

import com.SWP391.SWP391.DTO.Request.UserCreationRequest;
import com.SWP391.SWP391.DTO.Request.UserUpdateRequest;
import com.SWP391.SWP391.DTO.Response.UserResponse;
import com.SWP391.SWP391.Entity.User;
import com.SWP391.SWP391.Exception.AppException;
import com.SWP391.SWP391.Exception.ErrorCode;
import com.SWP391.SWP391.Mapper.UserMapper;
import com.SWP391.SWP391.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    //Khai báo bean do ở dưới dùng UserRepository
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    //CREATE USER
    public User createUser(UserCreationRequest request){
        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        //mã hóa password bằng Bcrypt
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

       return userRepository.save(user);
    }

    //GET LIST USERS
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    //Update User
    public UserResponse updateUser(String userID, UserUpdateRequest request){
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.updateUser(user, request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    //Delete User
    public void deleteUser(String userID){
        userRepository.deleteById(userID);
    }

}
