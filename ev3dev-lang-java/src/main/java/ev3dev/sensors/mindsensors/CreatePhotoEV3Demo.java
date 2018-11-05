package examples.sensors.mindsensors;


import ev3dev.actuators.Sound;
import ev3dev.sensors.Button;
import ev3dev.sensors.mindsensors.NXTCamV5;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

/**
 * Created by jabrena on 30/7/17.
 */
public class CreatePhotoEV3Demo {

    public static void main(String[] args){

        System.out.println("NXTCamV5 create Photo Demo");

        final NXTCamV5 camera = new NXTCamV5(SensorPort.S1);

        while (Button.ESCAPE.isUp()) {

            Button.waitForAnyPress();
            Delay.msDelay(5000);
            System.out.println("Creating photo");
            camera.createPhoto();
            Sound.getInstance().beep();
            Delay.msDelay(500);

        }

        System.exit(0);
    }
}
