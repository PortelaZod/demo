package com.example.demo.domains.service;

import com.example.demo.domains.entity.User;
import com.example.demo.domains.repository.UserRepository;
import com.example.demo.interfaces.dto.user_dto.UserRequestDto;
import com.example.demo.interfaces.dto.user_dto.UserResponseDto;
import com.example.demo.interfaces.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponseDto save(UserRequestDto dto){
       User newUser =  this.userMapper.toEntity(dto);
       UserResponseDto userDto = this.userMapper.toDto(newUser);
       this.userRepository.save(newUser);
       userDto.setUserId(newUser.getUserId());
       return userDto;
    }

    public List<UserResponseDto> userList(){
        List<UserResponseDto>userList = this.userRepository
                .findAll()
                .stream()
                .map(user-> this.userMapper.toDto(user))
                .collect(Collectors.toList());
        return userList;
    }

    public UserResponseDto findUser(String userId){
        var user = this.userRepository.findById(userId).get();
        return this.userMapper.toDto(user);
    }

    public UserResponseDto updateUserInfo(String id, UserRequestDto updatedUser){
           User lateUser =  this.userRepository.findById(id).get();
           lateUser.setName(updatedUser.getName());
           lateUser.setLastName(updatedUser.getLastName());
           this.userRepository.save(lateUser);
           return this.userMapper.toDto(lateUser);
    }

    public void deleteUser(String userId){
         this.userRepository.deleteById(userId);
    }
}
