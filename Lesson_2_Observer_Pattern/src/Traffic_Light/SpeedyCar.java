package Traffic_Light;

public class SpeedyCar implements LightObserver {
    private String previousLight;
    private int id;

    public SpeedyCar(int id) {
        this.id = id;
    }
    @Override
    public void setLight(String currentLight) {
        if("GREEN".equals(currentLight)) {
            System.out.println("Car " + id + " drives");
        } else if("YELLOW".equals(currentLight)) {
            if("RED".equals(previousLight)) {
                System.out.println("Car " + id + " drives at yellow");
            } else {
                System.out.println("Car " + id + " speeds up to run yellow light");
            }
        } else if("RED".equals(currentLight)) {
            System.out.println("Car " + id + " stops");
        }
        previousLight = currentLight;
    }

}
