package lejos.navigation.feature;

import ev3dev.sensors.Button;
import ev3dev.sensors.ev3.EV3TouchSensor;
import lejos.hardware.port.SensorPort;
import lejos.navigation.pilot.PilotConfig;
import lejos.robotics.Touch;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.FeatureDetector;
import lejos.robotics.objectdetection.FeatureListener;
import lejos.robotics.objectdetection.TouchFeatureDetector;

import java.io.IOException;

public class FeatureAvoider3 {

    public static void main(String[] args) throws IOException {

        final PilotConfig pilotConf = new PilotConfig();
        final DifferentialPilot pilot = pilotConf.getPilot();

        final int TOUCH_X_OFFSET = -4;
        final int TOUCH_Y_OFFSET = 16;
        final Touch ts = new EV3TouchSensor(SensorPort.S3);
        final FeatureDetector detector = new TouchFeatureDetector(ts, TOUCH_X_OFFSET, TOUCH_Y_OFFSET);

        detector.enableDetection(true);
        pilot.forward();
         
        detector.addListener(new FeatureListener() {
            public void featureDetected(Feature feature, FeatureDetector detector) {
                detector.enableDetection(false);
                pilot.travel(-30);
                pilot.rotate(30);
                detector.enableDetection(true);
                pilot.forward();
            }       
        });

        Button.waitForAnyPress();
    }
}