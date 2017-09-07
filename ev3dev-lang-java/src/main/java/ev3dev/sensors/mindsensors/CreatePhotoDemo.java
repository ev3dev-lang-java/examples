package ev3dev.sensors.mindsensors;


import ev3dev.actuators.Sound;
import ev3dev.sensors.mindsensors.NXTCamV5;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

/**
 * Created by jabrena on 30/7/17.
 */
public class CreatePhotoDemo {

    public static void main(String[] args){

        System.out.println("NXTCamV5 create Photo Demo");

        final NXTCamV5 camera = new NXTCamV5(SensorPort.S1);

        int counter = 0;
        boolean flag = true;
        while (flag) {

            Delay.msDelay(5000);
            System.out.println("Creating photo");
            camera.createPhoto();
            Sound.getInstance().beep();
            Delay.msDelay(500);

            counter++;
            if(counter > 5){
                break;
            }
        }

        System.exit(0);
    }
}
