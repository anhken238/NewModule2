package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> findAll(Pageable pageable);

    Student findById(Long id);

    void save(Student student);

    void remove(Long id);

    Iterable<com.codegym.model.Student> findAllByBook (Book book);
    Page<com.codegym.model.Student> findAllByNameContaining (String name, Pageable pageable);
    Student findByCode (String code);
}
