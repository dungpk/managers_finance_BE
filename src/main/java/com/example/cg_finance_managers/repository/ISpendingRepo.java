package com.example.cg_finance_managers.repository;

import com.example.cg_finance_managers.model.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ISpendingRepo extends JpaRepository<Spending, Long> {
}
