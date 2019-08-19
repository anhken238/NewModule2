package com.codegym.service;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Iterable<Book> findAll();
    Book   findById(Long id);
    void save(Book book);
    void remove(Long id);
    Page<Book> findAllById(Long id, Pageable pageable);
}
