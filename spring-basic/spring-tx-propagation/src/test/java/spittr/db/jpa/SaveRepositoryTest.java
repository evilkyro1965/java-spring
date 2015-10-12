package spittr.db.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import spittr.db.SaveRepository;
import spittr.db.UpdateRepository;
import spittr.domain.Spitter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JpaConfig.class)
@TransactionConfiguration(defaultRollback = false)
public class SaveRepositoryTest {

    @Autowired SaveRepository saveRepository;

    @Test
    public void testRequired()
    {
        Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee", "newbee@habuma.com", true);
        saveRepository.saveRequired(spitter);
    }

    @Test
    public void testRequiredNew()
    {
        Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee", "newbee@habuma.com", true);
        saveRepository.saveRequiredNew(spitter);
    }
}
