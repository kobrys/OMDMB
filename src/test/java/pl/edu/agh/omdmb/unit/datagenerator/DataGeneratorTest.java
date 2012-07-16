package pl.edu.agh.omdmb.unit.datagenerator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.datagenerator.DataGenerator;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DataGeneratorTest {

    @InjectMocks
    private DataGenerator dataGenerator = new DataGenerator();

    @Test
    public void shouldInitializeWithMetamodelClasses() {
        //given
        Class<?>[] metamodelClasses = new Class[]{Object.class, String.class};

        //when
        dataGenerator.initializeWith(metamodelClasses);

        //then
        assertThat(dataGenerator.getMetamodelClasses(), is(equalTo(Arrays.asList(metamodelClasses))));
    }


}
