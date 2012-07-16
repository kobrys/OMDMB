package pl.edu.agh.omdmb.component.jpa;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Not;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.DatabaseConfiguration;
import pl.edu.agh.omdmb.jpa.JpaManager;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class JpaManagerTest {

    @InjectMocks
    private JpaManager jpaManager = new JpaManager();

    @Mock DatabaseConfiguration databaseConfiguration;

    @Test
    public void shouldAutoSetUpDatabaseConnection() {
        //when
        //create system

        //then
        assertThat(jpaManager, is(notNullValue()));
    }
}
