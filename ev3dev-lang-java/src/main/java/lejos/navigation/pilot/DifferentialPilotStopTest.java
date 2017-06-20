package lejos.navigation.pilot;

import lejos.robotics.navigation.DifferentialPilot;

public class DifferentialPilotStopTest {

    public static void main(String[] args) {

        final PilotConfig pilotConf = new PilotConfig();
        final DifferentialPilot pilot = pilotConf.getPilot();
		pilot.stop();

    }
}