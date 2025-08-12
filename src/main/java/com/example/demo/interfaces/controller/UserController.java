package com.example.demo.interfaces.controller;

import com.example.demo.domains.service.UserService;
import com.example.demo.interfaces.dto.user_dto.UserRequestDto;
import com.example.demo.interfaces.dto.user_dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody(required = true) UserRequestDto userRequestDto){
        UserResponseDto newUser = this.userService.save(userRequestDto);
        URI location = URI.create("/api/user/" + newUser.getUserId());
        return ResponseEntity.created(location).body(newUser);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> userList(){
        return ResponseEntity.ok().body(this.userService.userList());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> findUser(@PathVariable String userId){
        var user = this.userService.findUser(userId);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDto> updateUserInfo(@PathVariable String userId, @RequestBody UserRequestDto userRequestDto){
        var updatedUser = this.userService.updateUserInfo(userId,userRequestDto);
        return ResponseEntity.ok().body(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        this.userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}
