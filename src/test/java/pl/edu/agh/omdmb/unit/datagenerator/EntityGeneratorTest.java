package pl.edu.agh.omdmb.unit.datagenerator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.datagenerator.EntityGenerator;

@RunWith(MockitoJUnitRunner.class)
public class EntityGeneratorTest {

    @InjectMocks
    private EntityGenerator entityGenerator;

    @Test
    public void shouldCreateGeneratorForClass() {
        //given
        Class<?> clazz = null;

        //when
//        entityGenerator.forClass(clazz);

        //then
        //??
    }
}
