package gym.repositoy;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();

    T findOneById(Long id);

    void save(T model);

    void remove(Long id);
}
