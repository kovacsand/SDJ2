package mediator;

import model.Temperature;
import util.Subject;

public interface TemperatureModel extends Subject
{
  void addTemperature(String id, double temperature);

  int getRadiatorPowerState();

  double getCriticalLow();

  double getCriticalHigh();

  void setCriticalLow(double criticalLow);

  void setCriticalHigh(double criticalHigh);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);

  void turnDownRadiator();

  void turnUpRadiator();
}
