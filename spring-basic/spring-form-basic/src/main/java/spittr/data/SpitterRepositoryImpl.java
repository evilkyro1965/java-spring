package spittr.data;

import org.springframework.stereotype.Service;
import spittr.Spitter;

/**
 * Created by Administrator on 10/7/15.
 */
@Service
public class SpitterRepositoryImpl implements SpitterRepository {

    public Spitter save(Spitter spitter){
        int i = 0;
        return spitter;
    }

    public Spitter findByUsername(String username){
        return new Spitter();
    }
}
