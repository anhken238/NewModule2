package com.na.service.impl;

import com.na.model.Category;
import com.na.model.Post;
import com.na.repository.IPostRepository;
import com.na.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


public class PostServiceImpl implements IPostService {
    @Autowired
    private IPostRepository iPostRepository;
    @Override
    public Page<Post> findAll(Pageable pageable) {
        pageable = new PageRequest(pageable.getPageNumber(),3);
        return iPostRepository.findAll(pageable);
    }

    @Override
    public Post findById(Long id) {
        return iPostRepository.findOne(id);
    }

    @Override
    public void save(Post post) {
        iPostRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        iPostRepository.delete(id);
    }

    @Override
    public Iterable<Post> findAllByCategory(Category category) {
        return iPostRepository.findAllByCategory(category);
    }

    @Override
    public Page<Post> findAllByPostNameContaining(String postName, Pageable pageable) {
        return iPostRepository.findAllByNamePostContaining(postName,pageable);
    }
}
