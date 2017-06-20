package lejos.navigation.pilot;

import ev3dev.sensors.Battery;
import lejos.robotics.navigation.DifferentialPilot;

public class DifferentialPilotTest1 {

    public static void main(final String[] args) {

        final PilotConfig pilotConf = new PilotConfig();
        final DifferentialPilot pilot = pilotConf.getPilot();

        pilot.travel(30);
        pilot.rotate(90);

        pilot.stop();

        //To Stop the motor in case of pkill java for example
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                pilot.stop();
                System.out.println(Battery.getInstance().getVoltage());
            }
        }));

    }
}
