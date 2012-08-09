package pl.edu.agh.omdmb.unit.datagenerator.generator;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.agh.omdmb.datagenerator.generator.ValueGenerator;

public class ValueGeneratorTest {

    private ValueGenerator<String> valueGenerator = new ValueGenerator<String>() {
    };

    @Test
    public void shouldReturnValueGeneratorForString() {
        //given
//        Class<?> stringClass = String.class;

        //when
        valueGenerator.generate();

        //then
//        Assert.assertThat(valueGenerator.getType(), String.class);
    }
}
