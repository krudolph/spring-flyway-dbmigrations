package de.kimrudolph.dbmigrations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFlywayMigrationsApplicationTest {

    @Autowired
    DemoEntityRepository demoEntityRepository;

    @Test
    public void smileyChanged() {

        for (DemoEntity demoEntity : demoEntityRepository.findAll()) {
            assertEquals(":-)", demoEntity.getSmiley());
        }
    }

}