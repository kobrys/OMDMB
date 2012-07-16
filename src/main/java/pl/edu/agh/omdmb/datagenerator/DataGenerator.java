package pl.edu.agh.omdmb.datagenerator;

import java.util.Arrays;
import java.util.List;

public class DataGenerator {

    private List<Class<?>> metamodelClasses;

    public void initializeWith(Class<?>... aMetamodelClasses) {
        metamodelClasses = Arrays.asList(aMetamodelClasses);
    }

    public List<Class<?>> getMetamodelClasses() {
        return metamodelClasses;
    }
}
