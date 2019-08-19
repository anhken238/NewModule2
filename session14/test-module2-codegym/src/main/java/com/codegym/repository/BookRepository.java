package com.codegym.repository;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    Page<Book> findAllById(Long id, Pageable pageable);
}
