package Traffic_Light_v2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrafficLight implements  PropertyChangeSubject {
    PropertyChangeSupport propertyChangeSupport;

    private String[] lights = {"GREEN", "YELLOW", "RED", "YELLOW"};
    private int count = 2;
    private String currentLight;

    public TrafficLight() {
        currentLight = lights[2];
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void start() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(2000);
            count = (count + 1) % 4;
            String previous = currentLight;
            currentLight = lights[count];
            System.out.println("\nLight is " + currentLight);

            lightChanged(previous, currentLight);
        }
    }

    private void lightChanged(String previous, String current) {
        propertyChangeSupport.firePropertyChange("LightChanged", previous, current);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
        listener.propertyChange(new PropertyChangeEvent(this, "LightChanged", currentLight, currentLight));
    }
}
