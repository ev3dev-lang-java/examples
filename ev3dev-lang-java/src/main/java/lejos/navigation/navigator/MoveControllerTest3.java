package lejos.navigation.navigator;

import ev3dev.sensors.Battery;
import ev3dev.sensors.ev3.EV3IRSensor;
import ev3dev.sensors.ev3.EV3UltrasonicSensor;
import lejos.hardware.port.SensorPort;
import lejos.navigation.pilot.PilotConfig;
import lejos.robotics.SampleProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.MoveController;

public class MoveControllerTest3 {

  MoveController pilot;
  EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1);
  SampleProvider bump = irSensor.getDistanceMode();
  float[] sample = new float[1];
 
  public void go() {
    pilot.forward();
    while (pilot.isMoving()) {
      bump.fetchSample(sample, 0);
      if (sample[0] < 20) pilot.stop();
    }
    float dist = pilot.getMovement().getDistanceTraveled();
    System.out.println("Distance = " + dist);
    pilot.travel(-dist);
  }
 
  public static void main(String[] args) {

    final MoveControllerTest3 traveler = new MoveControllerTest3();
    final PilotConfig pilotConf = new PilotConfig();
    final DifferentialPilot pilot = pilotConf.getPilot();

    //To Stop the motor in case of pkill java for example
    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
      public void run() {
        pilot.stop();
        System.out.println(Battery.getInstance().getVoltage());
      }
    }));

    traveler.pilot = pilot;
    traveler.go();
  }
}