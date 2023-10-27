package com.example.cg_finance_managers.repository;

import com.example.cg_finance_managers.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IWalletRepo extends JpaRepository<User,Long> {
}
