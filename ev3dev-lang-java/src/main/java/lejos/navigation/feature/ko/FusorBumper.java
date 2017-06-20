package lejos.navigation.feature.ko;

import ev3dev.sensors.Battery;
import ev3dev.sensors.Button;
import ev3dev.sensors.ev3.EV3TouchSensor;
import ev3dev.sensors.ev3.EV3UltrasonicSensor;
import lejos.hardware.port.SensorPort;
import lejos.navigation.pilot.PilotConfig;
import lejos.robotics.RangeFinderAdapter;
import lejos.robotics.Touch;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.objectdetection.*;

import java.io.IOException;

/**
 * This bumper-car example uses a FusorDetector to detect and report objects from multiple sensors. Use 
 * any pilot robot with an ultrasonic sensor plugged into port 4, and a touch sensor plugged into port 2.
 * The touch sensor is the bumper for detecting objects the ultrasonic fails to detect.
 * Make sure to set the proper pilot parameters in the constructor for your specific robot.
 * @author BB
 *
 */
public class FusorBumper implements FeatureListener {

	private static final int MAX_DETECT = 50;
	private static final int RANGE_READING_DELAY = 500;
	private static final int TOUCH_X_OFFSET = -4;
	private static final int TOUCH_Y_OFFSET = 16;

	private DifferentialPilot robot;

	public FusorBumper() throws IOException {

		final PilotConfig pilotConf = new PilotConfig();
		robot = pilotConf.getPilot();

		robot.forward();
	}

	public static void main(String[] args ) throws Exception {

		final float MAX_DISTANCE = 50f;
		final int DETECTOR_DELAY = 1000;

		final EV3UltrasonicSensor ir = new EV3UltrasonicSensor(SensorPort.S1);
		final RangeFeatureDetector usdetector = new RangeFeatureDetector(
				new RangeFinderAdapter(ir.getDistanceMode()), MAX_DISTANCE, DETECTOR_DELAY);

		Touch ts = new EV3TouchSensor(SensorPort.S3);
		FeatureDetector tsdetector = new TouchFeatureDetector(ts, TOUCH_X_OFFSET, TOUCH_Y_OFFSET); 

		FusorDetector fusion = new FusorDetector();
		fusion.addDetector(tsdetector);
		fusion.addDetector(usdetector);

		fusion.addListener(new FusorBumper());

		Button.waitForAnyPress();
	}

	public void featureDetected(Feature feature, FeatureDetector detector) {
		detector.enableDetection(false);
		System.out.println(Battery.getInstance().getVoltage());
		robot.travel(-MAX_DETECT + feature.getRangeReading().getRange()); // go back relative to distance from the feature
		robot.rotate(90 * Math.random());
		detector.enableDetection(true);
		robot.forward();
	}
}