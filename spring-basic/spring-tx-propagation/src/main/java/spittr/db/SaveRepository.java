package spittr.db;

import spittr.domain.Spitter;

/**
 * Created by Administrator on 10/10/15.
 */
public interface SaveRepository {
    void saveRequired(Spitter spitter);
    void saveRequiredNew(Spitter spitter);
}
