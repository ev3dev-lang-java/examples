package ev3dev.sensors.mindsensors;

import ev3dev.actuators.Sound;
import ev3dev.sensors.Button;
import ev3dev.sensors.mindsensors.NXTCamV5;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

/**
 * Created by jabrena on 30/7/17.
 */
public class TrackObjectsDemo {

    public static void main(String[] args){

        System.out.println("NXTCamV5 Track Object Demo");

        final NXTCamV5 camera = new NXTCamV5(SensorPort.S1);

        int counter = 0;
        while (Button.ESCAPE.isUp()) {
            counter++;
            System.out.println("Iteration: " + counter);

            int trackedObject = camera.getNumberOfObjects();
            System.out.println(trackedObject);

            if(trackedObject > 0) {
                Sound.getInstance().beep();
            }

            Delay.msDelay(1000);
        }

    }
}
