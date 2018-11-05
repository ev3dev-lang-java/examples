package examples.sensors.mindsensors;

import ev3dev.sensors.mindsensors.NXTCamV5;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

/**
 * Created by jabrena on 30/7/17.
 */
public class RecordVideoDemo {

    public static void main(String[] args){

        System.out.println("NXTCamV5 create Video Demo");

        final NXTCamV5 camera = new NXTCamV5(SensorPort.S1);

        System.out.println("Creating video");
        camera.createVideo();

        Delay.msDelay(20000);
        System.out.println("End process");

        System.exit(0);
    }
}
