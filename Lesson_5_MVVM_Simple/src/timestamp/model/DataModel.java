package timestamp.model;

public interface DataModel {

    String getLastUpdateTimeStamp();

    void increaseNumberOfUpdates();

    int getNumberOfUpdates();
}
