package com.example.cg_finance_managers.service.category;

import com.example.cg_finance_managers.model.Category;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Category> findAll() {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
