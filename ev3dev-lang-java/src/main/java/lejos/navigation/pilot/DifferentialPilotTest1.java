package lejos.navigation.pilot;

import ev3dev.sensors.Battery;
import lejos.robotics.navigation.DifferentialPilot;

public class DifferentialPilotTest1 {

    public static void main(final String[] args) {

        final PilotConfig pilotConf = new PilotConfig();
        final DifferentialPilot pilot = pilotConf.getPilot();

        pilot.travel(20);
        pilot.rotate(90);

        System.out.println("Voltage: " + Battery.getInstance().getVoltage());

    }
}
