package com.example.demo.interfaces.mapper;

import com.example.demo.domains.entity.User;
import com.example.demo.interfaces.dto.user_dto.UserRequestDto;
import com.example.demo.interfaces.dto.user_dto.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private ModelMapper modelMapper;

    UserMapper(){
        this.modelMapper = new ModelMapper();
    }

    public User toEntity(UserRequestDto dto){
        return this.modelMapper.map(dto,User.class);
    }

    public UserResponseDto toDto(User entity){
        return this.modelMapper.map(entity, UserResponseDto.class);
    }
}
