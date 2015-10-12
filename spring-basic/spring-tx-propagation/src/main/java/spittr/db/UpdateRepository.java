package spittr.db;

import spittr.domain.Spitter;

/**
 * Created by Administrator on 10/12/15.
 */
public interface UpdateRepository {
    void updateRequired(Spitter spitter);
    void updateRequiredNew(Spitter spitter);
}
