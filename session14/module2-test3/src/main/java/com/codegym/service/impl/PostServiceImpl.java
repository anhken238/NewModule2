package com.codegym.service.impl;

import com.codegym.model.Author;
import com.codegym.model.Post;
import com.codegym.repository.PostRepository;
import com.codegym.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public Page<Post> findAll(Pageable pageable) {
        pageable = new PageRequest(pageable.getPageNumber(), 5);
        return postRepository.findAll(pageable);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public void save(Post post) {
    postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
    postRepository.delete(id);
    }

    @Override
    public Iterable<Post> findAllByAuthor(Author author) {
        return postRepository.findAllByAuthor(author);
    }

    @Override
    public Page<Post> findAllByTitleContaining(String title, Pageable pageable) {
        return postRepository.findAllByTitleContaining(title,pageable);
    }
    @Override
    public Page<Post> findPostsByAuthorName(String nameAuthor, Pageable pageable) {
        return postRepository.findPostsByAuthorName(nameAuthor,pageable);
    }

//xoa mem trang thai status

    @Override
    public Page<Post> findAllByStatus(boolean status, Pageable pageable) {
        return postRepository.findAllByStatus(status, pageable);
    }

    @Override
    public Page<Post> findAllByTitleContainingAndStatus(String title, boolean status, Pageable pageable) {
        return postRepository.findAllByTitleContainingAndStatus(title,status,pageable);
    }

    @Override
    public Page<Post> findAllByStatusAndAuthor_NameAuthor(boolean status, String nameAuthor, Pageable pageable) {
        return postRepository.findAllByStatusAndAuthor_NameAuthor(status,nameAuthor,pageable);
    }
}
