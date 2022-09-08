package timestamp.model;

public interface DataModel extends PropertyChangeSubject{

    String getLastUpdateTimeStamp();
    void increaseNumberOfUpdates();
    int getNumberOfUpdates();
}
