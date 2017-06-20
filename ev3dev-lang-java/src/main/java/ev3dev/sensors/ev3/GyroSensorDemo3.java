package ev3dev.sensors.ev3;

import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import org.slf4j.Logger;

public class GyroSensorDemo3 {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(GyroSensorDemo3.class);
	//Robot Configuration
	private static EV3GyroSensor gyroSensor = new EV3GyroSensor(SensorPort.S1);

	//Configuration
	private static int HALF_SECOND = 500;

	public static void main(String[] args) {

		final SampleProvider sp = gyroSensor.getAngleAndRateMode();
		int value = 0;

		int iterationCounter = 0;

        //Control loop
		while(true){
			float [] sample = new float[sp.sampleSize()];
            sp.fetchSample(sample, 0);
            value = (int)sample[0];

            log.info("Gyro angle/rate: {}", value);

			if(value >= 90){
				//Sound.getInstance().beep();
				log.info("Rotated 90 degrees");
				break;
			}

			iterationCounter++;
			if(iterationCounter >= 100){
				break;
			}

			Delay.msDelay(HALF_SECOND);
		}

	}

}
