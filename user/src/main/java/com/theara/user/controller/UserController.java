package com.theara.user.controller;

import com.theara.user.dto.ResponseDto;
import com.theara.user.entity.User;
import com.theara.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User userBody = this.userService.saveUser(user);
        return new ResponseEntity<>(userBody, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable Long id){
        ResponseDto responseDto = this.userService.findAll(id);
        return ResponseEntity.ok(responseDto);
    }
}
