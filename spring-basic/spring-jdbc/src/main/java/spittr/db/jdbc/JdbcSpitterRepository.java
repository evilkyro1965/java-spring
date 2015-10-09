package spittr.db.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import spittr.db.SpitterRepository;
import spittr.domain.Spitter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 10/9/15.
 */
public class JdbcSpitterRepository implements SpitterRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcSpitterRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Spitter save(Spitter spitter) {
        Long id = spitter.getId();
        if (id == null) {
            long spitterId = insertSpitterAndReturnId(spitter);
            return new Spitter(spitterId, spitter.getUsername(), spitter.getPassword(), spitter.getFullName(), spitter.getEmail(), spitter.isUpdateByEmail());
        }
        return spitter;
    }

    public long insertSpitterAndReturnId(Spitter spitter){
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("Spitter");
        jdbcInsert.setGeneratedKeyName("id");
        Map<String,Object> args = new HashMap<String, Object>();
        args.put("username",spitter.getUsername());
        args.put("password",spitter.getPassword());
        args.put("fullname",spitter.getFullName());
        args.put("email",spitter.getEmail());
        args.put("updateByEmail",spitter.isUpdateByEmail());
        long spitterId = jdbcInsert.executeAndReturnKey(args).longValue();
        return spitterId;
    }

}
