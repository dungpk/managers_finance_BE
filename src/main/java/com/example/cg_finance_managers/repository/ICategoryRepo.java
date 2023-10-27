package com.example.cg_finance_managers.repository;

import com.example.cg_finance_managers.model.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ICategoryRepo extends JpaRepository<Category, Long> {
}
