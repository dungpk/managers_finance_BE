package com.example.cg_finance_managers.repository;

import com.example.cg_finance_managers.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends JpaRepository<Long, Category> {
}
