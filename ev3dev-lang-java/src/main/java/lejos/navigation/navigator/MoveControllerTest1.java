package lejos.navigation.navigator;

import ev3dev.sensors.Battery;
import lejos.navigation.pilot.PilotConfig;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Pose;
import lejos.robotics.navigation.Waypoint;

import java.io.IOException;

public class MoveControllerTest1 {

	public static void main(String[] args) throws IOException {

		PilotConfig pilotConf = new PilotConfig();
		final DifferentialPilot pilot = pilotConf.getPilot();

		final OdometryPoseProvider odometry = new OdometryPoseProvider(pilot);
		final Navigator navigator = new Navigator(pilot, odometry); // cria um navegador para indicar Path's

		Waypoint waypoint = new Waypoint(0, 0);
		navigator.addWaypoint(waypoint);
		waypoint = new Waypoint(20, 0);
		navigator.addWaypoint(waypoint);
		waypoint = new Waypoint(20, 20);
		navigator.addWaypoint(waypoint);
		waypoint = new Waypoint(20, 0);
		navigator.addWaypoint(waypoint);
		waypoint = new Waypoint(0, 0);
		navigator.addWaypoint(waypoint);

		navigator.followPath();
		navigator.waitForStop();

		show(navigator.getPoseProvider().getPose());

		System.out.println("Voltage: {}" + Battery.getInstance().getVoltage());

	}

	private static void show(Pose p) {
		System.out.println("Pose X " + p.getX());
		System.out.println("Pose Y " + p.getY());
		System.out.println("Pose V " + p.getHeading());
	}
}