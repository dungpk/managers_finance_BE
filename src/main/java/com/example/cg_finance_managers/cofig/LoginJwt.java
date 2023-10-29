package com.example.cg_finance_managers.cofig;

import com.example.cg_finance_managers.model.User;
import com.example.cg_finance_managers.service.user.IUserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/jwt/")
public class LoginJwt {
    @Autowired
    private IUserService userService;

    @PostMapping("login/{id}")
    private ResponseEntity<Claims> testId(@RequestParam("email") String email,
                                          @RequestParam("password") String password,
                                          @PathVariable("id") Long id) {
        Optional<User> user = userService.findById(id);
        if(user.isPresent()){
            if (user.get().getEmail().equals(email) && user.get().getPassword().equals(password)) {
                String jwt = Jwt.createJWT(user.get());
                Claims jwtExample = Jwt.decryptionJwt(jwt);
                user.get().setJWT(jwt);
                userService.save(user.get());
                return new ResponseEntity<>(jwtExample, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
