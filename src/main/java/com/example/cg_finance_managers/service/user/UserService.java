package com.example.cg_finance_managers.service.user;

import com.example.cg_finance_managers.model.User;
import com.example.cg_finance_managers.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo userRepo;

    @Override
    public User save(User user) {
         return userRepo.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public User createUser(User user) throws Exception{
        if(userRepo.findUsersByEmail(user.getEmail()).isPresent()){
            throw new Exception("email này đã được đăng ký");
        }
        return userRepo.save(user);
    }


}
