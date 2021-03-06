package spittr.db.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import spittr.db.SpitterRepository;
import spittr.domain.Spitter;

/**
 * Created by Administrator on 10/10/15.
 */
@Repository
@Transactional
public class JpaSpitterRepository implements SpitterRepository  {

    @PersistenceContext
    private EntityManager entityManager;

    public Spitter save(Spitter spitter) {
        entityManager.persist(spitter);
        return spitter;
    }

}
