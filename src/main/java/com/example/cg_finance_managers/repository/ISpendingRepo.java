package com.example.cg_finance_managers.repository;

import com.example.cg_finance_managers.model.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISpendingRepo  extends JpaRepository<Long, Spending> {
}
