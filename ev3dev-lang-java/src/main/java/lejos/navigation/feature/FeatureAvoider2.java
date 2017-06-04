package lejos.navigation.feature;

import ev3dev.sensors.Button;
import ev3dev.sensors.ev3.EV3UltrasonicSensor;
import lejos.hardware.port.SensorPort;
import lejos.navigation.pilot.PilotConfig;
import lejos.robotics.RangeFinderAdapter;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.FeatureDetector;
import lejos.robotics.objectdetection.FeatureListener;
import lejos.robotics.objectdetection.RangeFeatureDetector;

import java.io.IOException;

public class FeatureAvoider2 {
     
    static final float MAX_DISTANCE = 50f;
    static final int DETECTOR_DELAY = 1000;
 
    public static void main(String[] args) throws IOException {

        final PilotConfig pilotConf = new PilotConfig();
        final DifferentialPilot pilot = pilotConf.getPilot();

        final EV3UltrasonicSensor ir = new EV3UltrasonicSensor(SensorPort.S1);
        final RangeFeatureDetector detector = new RangeFeatureDetector(
                new RangeFinderAdapter(ir.getDistanceMode()), MAX_DISTANCE, DETECTOR_DELAY);

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