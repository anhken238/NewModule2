package com.na.repository;

import com.na.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPostRepository extends PagingAndSortingRepository<com.na.model.Post, Long> {
        Iterable<com.na.model.Post> findAllByCategory (Category category);
        Page<com.na.model.Post> findAllByNamePostContaining(String postName, Pageable pageable);
}
