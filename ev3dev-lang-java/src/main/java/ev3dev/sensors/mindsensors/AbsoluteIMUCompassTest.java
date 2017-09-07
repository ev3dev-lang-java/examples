package ev3dev.sensors.mindsensors;

import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

/**
 * Created by jabrena on 3/9/17.
 */
public class AbsoluteIMUCompassTest {

    private static int HALF_SECOND = 500;

    public static void main(String[] args) {

        System.out.println("Absolute IMU Demo");

        final AbsoluteIMU absoluteIMU = new AbsoluteIMU(SensorPort.S1);
        SampleProvider sp = absoluteIMU.getCompassMode();

        int sampleSize = sp.sampleSize();
        System.out.println("Sample Size:" + sampleSize);
        float[] sample = new float[sampleSize];

        // Takes some samples and prints them
        for (int i = 0; i < 10; i++) {
            sp.fetchSample(sample, 0);

            System.out.println("N={} Sample={}" + i + " " +  sample[0]);

            Delay.msDelay(HALF_SECOND);

        }


    }

}
