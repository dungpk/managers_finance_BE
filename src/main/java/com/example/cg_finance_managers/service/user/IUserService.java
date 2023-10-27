package com.example.cg_finance_managers.service.user;

import com.example.cg_finance_managers.model.User;
import com.example.cg_finance_managers.service.IGenerateService;
import org.springframework.stereotype.Service;

import java.util.Date;


public interface IUserService extends IGenerateService<User> {
    User createUser (User user) throws Exception;
    void updateUserInformation(Long userId, String fullName, String address, Date birthday,String email);

    void updatePasswordUser(Long id,String newPassword);

}
