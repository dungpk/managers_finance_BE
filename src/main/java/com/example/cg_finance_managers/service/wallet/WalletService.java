package com.example.cg_finance_managers.service.wallet;

import com.example.cg_finance_managers.model.Wallet;
import com.example.cg_finance_managers.repository.IWalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService implements IWalletService {
    @Autowired
    private IWalletRepo walletRepo;
    @Override
    public Wallet save(Wallet wallet) {
        return null;
    }

    @Override
    public Optional<Wallet> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Wallet> findAll() {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
