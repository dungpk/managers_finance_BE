package com.example.cg_finance_managers.controller;

import com.example.cg_finance_managers.model.User;
import com.example.cg_finance_managers.model.dto.UserDto;
import com.example.cg_finance_managers.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping("register")
    private ResponseEntity<?> createUser(@RequestBody UserDto userDto, BindingResult bindingResult) throws Exception {
        User user = new User();
        if (bindingResult.hasErrors()) {

               List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        try {
            if (userDto.getPassword().equals(userDto.getConfirmPassword())) {
                user.setEmail(userDto.getEmail());
                user.setPassword(userDto.getPassword());
                return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Mật khẩu không khớp", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
