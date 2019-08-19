package com.codegym.repository;

import com.codegym.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<com.codegym.model.Customer, Long> {
    Iterable<com.codegym.model.Customer> findAllByProvince(Province province);

    Page<com.codegym.model.Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
