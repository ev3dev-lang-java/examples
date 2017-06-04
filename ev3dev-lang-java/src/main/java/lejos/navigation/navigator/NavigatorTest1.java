package lejos.navigation.navigator;

import ev3dev.sensors.Battery;
import lejos.navigation.pilot.PilotConfig;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;

import java.io.IOException;

public class NavigatorTest1 {

    public static void main(final String[] args) throws IOException {

        PilotConfig pilotConf = new PilotConfig();
        final DifferentialPilot pilot = pilotConf.getPilot();

        OdometryPoseProvider pp = new OdometryPoseProvider(pilot);
        Navigator navigator = new Navigator(pilot, pp);

        navigator.singleStep(true);

        navigator.addWaypoint(0.0f, 40.0f, 0.0f);

        navigator.followPath();
        navigator.waitForStop();

        System.out.println("{}" + navigator.getPoseProvider().getPose().toString());

        System.out.println("Voltage: {}" + Battery.getInstance().getVoltage());

    }
}
