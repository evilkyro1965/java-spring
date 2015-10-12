package spittr.db.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spittr.db.SaveRepository;
import spittr.db.UpdateRepository;
import spittr.domain.Spitter;
import sun.security.provider.ConfigFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Administrator on 10/10/15.
 */
@Repository
@Transactional
public class SaveRepositoryImpl implements SaveRepository{

    @Autowired
    UpdateRepository updateRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveRequired(Spitter spitter) {
        entityManager.persist(spitter);
        Spitter copy = new Spitter(null, spitter.getFullName(), spitter.getPassword(), spitter.getUsername(), spitter.getEmail(), true);
        updateRepository.updateRequired(copy);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveRequiredNew(Spitter spitter) {
        entityManager.persist(spitter);
        Spitter copy = new Spitter(null, spitter.getFullName(), spitter.getPassword(), spitter.getUsername(), spitter.getEmail(), true);
        try {
            updateRepository.updateRequiredNew(copy);
        }
        catch (Exception e){

        }
    }

}
