package pl.edu.agh.omdmb.util;

import junit.framework.Assert;
import org.apache.commons.digester3.Digester;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.omdmb.configuration.benchmark.model.Scenario;

import java.io.File;

import static junit.framework.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class XmlToObjectLoaderTest {

    public static final String FILENAME = "filename";
    private XmlToObjectLoader instance;

    @Mock Digester digester;
    @Mock Scenario scenario;

    @Before
    public void setUp() {
        instance = new XmlToObjectLoader();
        instance.setDigester(digester);
    }

    @Test
    public void shouldLoadScenarioFromFile() throws Exception {
        //given
        given(digester.parse(any(File.class))).willReturn(scenario);

        //when
        Scenario returnedValue = instance.loadFromFile(FILENAME);

        //then
        verify(digester.parse(any(File.class)));
        assertEquals(scenario, returnedValue);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeExceptionWhenExceptionCatched() throws Exception {
        //given
        given(digester.parse(any(File.class))).willThrow(new RuntimeException());

        //when
        Scenario returnedValue = instance.loadFromFile(FILENAME);
    }

}
