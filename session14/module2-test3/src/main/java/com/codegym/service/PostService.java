package com.codegym.service;

import com.codegym.model.Author;
import com.codegym.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Page<Post> findAll(Pageable pageable);

    Post findById(Long id);

    void save(Post post);

    void remove(Long id);

    Iterable<Post> findAllByAuthor(Author author);

    Page<Post> findAllByTitleContaining(String title, Pageable pageable);

    Page<Post> findPostsByAuthorName(String nameAuthor, Pageable pageable);

    //xoa mem trang thai status
    Page<Post> findAllByStatus(boolean status, Pageable pageable);

    Page<Post> findAllByTitleContainingAndStatus(String title, boolean status, Pageable pageable);

    Page<Post> findAllByStatusAndAuthor_NameAuthor(boolean status, String nameAuthor, Pageable pageable);

}
