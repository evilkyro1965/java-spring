package spittr.jdbc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import spittr.db.jdbc.JdbcSpitterRepository;
import spittr.domain.Spitter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:JdbcRepositoryTests-context.xml")
public class JdbcSpitterRepositoryTest {

    @Autowired
    JdbcSpitterRepository spitterRepository;

    @Test
    @Transactional
    public void save_newSpitter() {
        Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee",
                "newbee@habuma.com", true);
        Spitter saved = spitterRepository.save(spitter);
    }
}
