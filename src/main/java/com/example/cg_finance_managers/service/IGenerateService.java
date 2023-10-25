
package com.example.cg_finance_managers.service;

import java.util.Optional;

public interface IGenerateService<T> {
    T save(T t);
    Optional<T> findById(Long id);
    Iterable<T>findAll();
    void remove(Long id);
}
