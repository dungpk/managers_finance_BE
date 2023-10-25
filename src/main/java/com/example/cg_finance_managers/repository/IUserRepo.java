package com.example.cg_finance_managers.repository;

import com.example.cg_finance_managers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface IUserRepo extends JpaRepository<User,Long> {
    Optional<User>findUsersByEmail(String email);
}
