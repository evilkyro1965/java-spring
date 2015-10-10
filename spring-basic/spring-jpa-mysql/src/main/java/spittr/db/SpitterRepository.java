package spittr.db;

import java.util.List;

import spittr.domain.Spitter;

/**
 * Created by Administrator on 10/10/15.
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);
}
