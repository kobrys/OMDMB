package pl.edu.agh.omdmb.configuration.benchmark.model;

public class ExecutionParameters {

    private Double dataDensity;
    private Double overlap;
    private Integer numberOfObjects;
    private Double independence;

    public ExecutionParameters() {

    }

    public Double getDataDensity() {
        return dataDensity;
    }

    public void setDataDensity(Double dataDensity) {
        this.dataDensity = dataDensity;
    }

    public Double getOverlap() {
        return overlap;
    }

    public void setOverlap(Double overlap) {
        this.overlap = overlap;
    }

    public Integer getNumberOfObjects() {
        return numberOfObjects;
    }

    public void setNumberOfObjects(Integer numberOfObjects) {
        this.numberOfObjects = numberOfObjects;
    }

    public Double getIndependence() {
        return independence;
    }

    public void setIndependence(Double independence) {
        this.independence = independence;
    }
}
