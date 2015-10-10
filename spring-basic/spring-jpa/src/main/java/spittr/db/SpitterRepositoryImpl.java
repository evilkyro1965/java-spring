package spittr.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spittr.domain.Spitter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Administrator on 10/10/15.
 */
@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Spitter save(Spitter spitter) {
        entityManager.persist(spitter);
        return spitter;
    }

}
