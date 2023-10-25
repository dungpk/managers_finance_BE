package com.example.cg_finance_managers.service;

import com.example.cg_finance_managers.model.User;
import org.springframework.stereotype.Service;


public interface IUserService extends IGenerateService<User> {
    User createUser (User user) throws Exception;

}
