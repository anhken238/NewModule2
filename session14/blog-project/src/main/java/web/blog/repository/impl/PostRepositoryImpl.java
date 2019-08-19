package web.blog.repository.impl;

import web.blog.model.Blog;
import web.blog.repository.IPostRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class PostRepositoryImpl implements IPostRepository {
    @Override
    public List<Blog> findAll() {

        return null;
    }

    @Override
    public Blog findOneByID(long id) {
        return null;
    }

    @Override
    public void save(Blog model) {

    }

    @Override
    public void remove(long id) {

    }
}
