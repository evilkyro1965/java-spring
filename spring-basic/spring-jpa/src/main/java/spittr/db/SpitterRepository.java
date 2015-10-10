package spittr.db;

import spittr.domain.Spitter;

/**
 * Repository interface with operations for {@link spittr.domain.Spitter} persistence.
 * @author habuma
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);

}
