package examples;

import ev3dev.sensors.ev3.EV3UltrasonicSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultipleUSSensors {

    public static Logger LOGGER = LoggerFactory.getLogger(MultipleUSSensors.class);

    public static void main(final String[] args) {

        EV3UltrasonicSensor us1 = new EV3UltrasonicSensor(SensorPort.S1);
        EV3UltrasonicSensor us2 = new EV3UltrasonicSensor(SensorPort.S2);

        final SampleProvider sp2 = us2.getDistanceMode();
        float [] sample2 = new float[sp2.sampleSize()];
        sp2.fetchSample(sample2, 0);

        final SampleProvider sp = us1.getListenMode();
        int distanceValue = 0;

        final int iteration_threshold = 100;
        for(int i = 0; i <= iteration_threshold; i++) {

            float [] sample = new float[sp.sampleSize()];
            sp.fetchSample(sample, 0);
            distanceValue = (int) sample[0];

            LOGGER.info("Iteration: {}, Listen: {}", i, distanceValue);

            Delay.msDelay(500);
        }

    }

}
