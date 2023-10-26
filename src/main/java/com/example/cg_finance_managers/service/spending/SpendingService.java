package com.example.cg_finance_managers.service.spending;

import com.example.cg_finance_managers.model.Spending;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpendingService  implements ISpendingService{
    @Override
    public Spending save(Spending spending) {
        return null;
    }

    @Override
    public Optional<Spending> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Spending> findAll() {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
