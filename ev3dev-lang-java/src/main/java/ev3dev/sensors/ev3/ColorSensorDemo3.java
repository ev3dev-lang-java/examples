package ev3dev.sensors.ev3;

import lejos.hardware.port.SensorPort;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class ColorSensorDemo3 {

	//Robot Configuration
	private static EV3ColorSensor color1 = new EV3ColorSensor(SensorPort.S1);
	
	//Configuration
	private static int HALF_SECOND = 500;
	
	public static void main(String[] args) {

		//Color ID
		System.out.println("Switching to Color ID Mode");
		SampleProvider sp = color1.getColorIDMode();
		
		int sampleSize = sp.sampleSize();
		float[] sample = new float[sampleSize];

		System.out.println("Switching to Color ID Mode");
		sp = color1.getColorIDMode();

		int value = 0;

        // Takes some samples and prints them
        for (int i = 0; i < 100; i++) {
        	sp.fetchSample(sample, 0);
			value = (int)sample[0];

			System.out.println("N={} Sample={}" + i +  value);
            
            Delay.msDelay(HALF_SECOND);

			if(value == Color.BLUE){
				System.out.println("Blue ball found");
				break;
			}
        }

	}

}
