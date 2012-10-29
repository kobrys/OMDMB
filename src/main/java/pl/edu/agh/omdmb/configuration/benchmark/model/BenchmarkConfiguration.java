package pl.edu.agh.omdmb.configuration.benchmark.model;

public class BenchmarkConfiguration {

    private String jpaPersistenceFileName;
    private DataModel dataModel;

    public String getJpaPersistenceFileName() {
        return jpaPersistenceFileName;
    }

    public void setJpaPersistenceFileName(String jpaPersistenceFileName) {
        this.jpaPersistenceFileName = jpaPersistenceFileName;
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }
}
