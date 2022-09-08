package timestamp.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataModelManager implements DataModel {

    private String lastUpdate;

    private int numberOfUpdates;

    public DataModelManager() {
        System.out.println("Ny DataModel");
        this.numberOfUpdates = 0;
    }

    @Override
    public String getLastUpdateTimeStamp() {
        return lastUpdate;
    }

    public void recalculateData() {
        calcTimeStamp();
    }

    private void calcTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        System.out.println(strDate);
        lastUpdate = strDate;
    }

    public void increaseNumberOfUpdates()
    {
        numberOfUpdates++;
    }

    public int getNumberOfUpdates()
    {
        return numberOfUpdates;
    }
}
