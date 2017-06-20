package lejos.navigation.navigator;

import ev3dev.sensors.Battery;
import lejos.navigation.pilot.PilotConfig;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;

public class NavigatorTest2 {

    public static void main(final String[] args) {

        PilotConfig pilotConf = new PilotConfig();
        final DifferentialPilot pilot = pilotConf.getPilot();

        OdometryPoseProvider pp = new OdometryPoseProvider(pilot);
        Navigator navigator = new Navigator(pilot, pp);

        navigator.goTo(0,0);
        navigator.goTo(100,0);
        navigator.goTo(50,50);
        navigator.goTo(100,-50);
        navigator.goTo(0,0);
        navigator.followPath();
        navigator.waitForStop();

        System.out.println(pp.getPose());

        System.out.println("Voltage: " + Battery.getInstance().getVoltage());

    }

}
