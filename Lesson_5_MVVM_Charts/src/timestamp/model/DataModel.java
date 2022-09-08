package timestamp.model;

public interface DataModel {
    double[] getDataValues();

    String getLastUpdateTimeStamp();

    void saveData(double x, double y, double z);
}
