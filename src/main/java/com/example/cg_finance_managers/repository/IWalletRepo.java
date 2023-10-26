package com.example.cg_finance_managers.repository;

import com.example.cg_finance_managers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IWalletRepo extends JpaRepository<User,Long> {
}
