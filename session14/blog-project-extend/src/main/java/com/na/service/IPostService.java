package com.na.service;

import com.na.model.Category;
import com.na.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {
    Page<Post> findAll(Pageable pageable);


    Post findById(Long id);

    void save(Post post);

    void remove(Long id);

    Iterable<Post> findAllByCategory(Category category);

    Page<Post> findAllByPostNameContaining(String postName, Pageable pageable);
}
