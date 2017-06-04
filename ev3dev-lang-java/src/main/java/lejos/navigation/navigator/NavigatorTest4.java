package lejos.navigation.navigator;

import ev3dev.sensors.Button;
import lejos.navigation.pilot.PilotConfig;
import lejos.robotics.localization.*;
import lejos.robotics.navigation.*;

public class NavigatorTest4 implements NavigationListener{

	static DifferentialPilot  pilot;
	static OdometryPoseProvider pp;
	static Navigator navigator;
	static NavigationListener nLis;
	
	public static void main(String[] args) throws Exception {

		PilotConfig pilotConf = new PilotConfig();
		pilot = pilotConf.getPilot();
		pp= new OdometryPoseProvider(pilot);
		navigator = new Navigator(pilot, pp);
		
		nLis = new NavigatorTest4();
		navigator.addNavigationListener(nLis);

		navigator.addWaypoint(0.0f, 40.0f, 0.0f);

		navigator.followPath();
		navigator.waitForStop();

		Button.waitForAnyPress();
	}

	@Override
	public void atWaypoint(Waypoint waypoint, Pose pose, int sequence) {
		try{
			System.out.println("atWaypoint");
		} catch (Exception e) {}
	}

	@Override
	public void pathComplete(Waypoint waypoint, Pose pose, int sequence) {
		System.out.println("pathComplete");
	}

	@Override
	public void pathInterrupted(Waypoint waypoint, Pose pose, int sequence){
		try {

			Thread.sleep(4000);
			navigator.goTo(waypoint);
		} catch (Exception e) {}
	}
}