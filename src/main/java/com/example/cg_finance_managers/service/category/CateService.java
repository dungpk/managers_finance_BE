package com.example.cg_finance_managers.service.category;

import com.example.cg_finance_managers.model.Category;
import com.example.cg_finance_managers.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CateService implements ICategoryService{
    @Autowired
    private ICategoryRepo categoryRepo;
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
