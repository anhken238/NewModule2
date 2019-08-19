package gym.repositoy.impl;

import gym.model.Event;
import gym.repositoy.IEventRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventRepositoryImpl implements IEventRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Event> findAll() {
        TypedQuery<Event> query = em.createQuery("select c from Event c", Event.class);
        return query.getResultList();
    }

    @Override
    public Event findOneById(Long id) {
        TypedQuery<Event> query = em.createQuery("select c from Event c Where c.id=:id", Event.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Event model) {
        if (model.getId() != null) {
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Event event = findOneById(id);
        if(event != null ){
            em.remove(event);
        }
    }
}
