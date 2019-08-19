package com.codegym.repository;

import com.codegym.model.Book;
import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<com.codegym.model.Student, Long> {
    Iterable<com.codegym.model.Student> findAllByBook (Book book);
    Page<com.codegym.model.Student> findAllByNameContaining (String name, Pageable pageable);
    Student findByCode (String code);
}
