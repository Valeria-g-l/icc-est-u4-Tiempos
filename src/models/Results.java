package models;

public class Results {
    private int sampleSize;
    private String funtionName;
    private double timeResult;

    public Results(int sampleSize, String funtionName, double timeResult) {
        this.sampleSize = sampleSize;
        this.funtionName = funtionName;
        this.timeResult = timeResult;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(int sampleSize) {
        this.sampleSize = sampleSize;
    }

    public String getFuntionName() {
        return funtionName;
    }

    public void setFuntionName(String funtionName) {
        this.funtionName = funtionName;
    }

    public double getTimeResult() {
        return timeResult;
    }

    public void setTimeResult(double timeResult) {
        this.timeResult = timeResult;
    }

    @Override
    public String toString() {
        return "La funcion " + funtionName + " ejecutada " + sampleSize + " veces, tuvo una duracion de: " + timeResult + " segundos" ;
    }

    

    
    
}
