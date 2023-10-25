package com.example.cg_finance_managers.service;

import com.example.cg_finance_managers.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;


public interface IUserService extends IGenerateService<User> {
    User createUser (User user) throws Exception;
    boolean checkPasswordAndConfrimPassword(User user);
    void updateUserInformation(Long userId, String fullName, String address, Date birthday,String email);

}
