package com.example.cg_finance_managers.controller;

import com.example.cg_finance_managers.dto.user_dto.password.UserPassword;
import com.example.cg_finance_managers.model.User;
import com.example.cg_finance_managers.model.dto.UserDto;
import com.example.cg_finance_managers.service.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService userService;

    private ResponseEntity<?> errorBadRequest(BindingResult bindingResult){
        List<String> errors = bindingResult.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }

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

    @PutMapping("information/{id}")
    public ResponseEntity<?> updateUserInformation(@PathVariable("id") Long id,@Valid @RequestBody UserInformation userInformation, BindingResult result){
        if (result.hasErrors()) {
                List<String> errors = result.getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList());
                return ResponseEntity.badRequest().body(errors);
        }
        Optional<User> userOptional = userService.findById(id);
        if(userOptional.isPresent()){
            try {
                userService.updateUserInformation(id,userInformation.getFullName(),userInformation.getAddress(),
                        userInformation.getBirthday(),userInformation.getEmail());
                return new ResponseEntity<>(userInformation, HttpStatus.OK);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }

        }else{
            return new ResponseEntity<>("User not Found",HttpStatus.NO_CONTENT);
        }
    }


    @PostMapping("/updatePassword/{id}")
    public ResponseEntity<?> changeUserPassword(Locale locale, @PathVariable("id") Long id, @Valid @RequestBody UserPassword userPassword, BindingResult result){
        if(result.hasErrors()){
            return errorBadRequest(result);
        }
        Optional<User> userOptional = userService.findById(id);

        if(userOptional.isPresent()){
            if(!userOptional.get().getPassword().equals(userPassword.getOldPassword())){
                return ResponseEntity.badRequest().body("PassWord Do not Match");
            }
            try {
                userService.updatePasswordUser(id,userPassword.getNewPassword());
                return new ResponseEntity<>(userPassword.getNewPassword(), HttpStatus.OK);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }

        }else{
            return new ResponseEntity<>("Change Password Failed",HttpStatus.NO_CONTENT);
        }

    }

}
