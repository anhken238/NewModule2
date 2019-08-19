package web.blog.repository;

import java.util.List;

public interface IReporsitory<T> {
    List<T> findAll();

    T findOneByID(long id);

    void save(T model);

    void remove(long id);
}
