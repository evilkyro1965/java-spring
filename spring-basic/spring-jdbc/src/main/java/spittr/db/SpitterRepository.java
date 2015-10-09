package spittr.db;

import java.util.List;

import spittr.domain.Spitter;

/**
 * Repository interface with operations for {@link Spitter} persistence.
 * @author habuma
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);

}
