package spittr.db.jpa;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import spittr.db.SpitterRepository;
import spittr.domain.Spitter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:RepositoryTest-context.xml")
public class SpitterRepositoryTest {

    @Autowired
    SpitterRepository spitterRepository;

    @Test
    @Transactional
    public void save_newSpitter() {
        Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee", "newbee@habuma.com", true);
        Spitter saved = spitterRepository.save(spitter);
    }

}
