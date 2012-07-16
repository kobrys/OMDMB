package pl.edu.agh.omdmb.component.datagenerator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.datagenerator.DataGenerator;

@RunWith(MockitoJUnitRunner.class)
public class DataGeneratorComponentTest {

    @InjectMocks
    private DataGenerator dataGenerator;

    @Mock Class<?> clazz;

    @Test
    public void shouldGenerateSimpleStringEntity() {
        //given
        dataGenerator.initializeWith(clazz);

        //when
//        dataGenerator.generateEntity();

        //then
    }

}
