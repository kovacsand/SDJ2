package Traffic_Light_v2;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight light = new TrafficLight();
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        light.addPropertyChangeListener(car1);
        light.addPropertyChangeListener(car2);

        SpeedyCar speedyCar1 = new SpeedyCar(3);
        light.addPropertyChangeListener(speedyCar1);
        Taxi taxi1 = new Taxi(1);
        light.addPropertyChangeListener(taxi1);
        SleepyDriver sleepyDriver1 = new SleepyDriver(6);
        light.addPropertyChangeListener(sleepyDriver1);
        Pedestrian pedestrian1 = new Pedestrian(9);
        light.addPropertyChangeListener(pedestrian1);

        light.start();
    }
}
