package spittr.db.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spittr.db.UpdateRepository;
import spittr.domain.Spitter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Administrator on 10/12/15.
 */
@Repository
@Transactional
public class UpdateRepositoryImpl implements UpdateRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateRequired(Spitter spitter) {
        entityManager.persist(spitter);
        int i = 1/0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateRequiredNew(Spitter spitter) {
        entityManager.persist(spitter);
        int i = 1/0;
    }
}
