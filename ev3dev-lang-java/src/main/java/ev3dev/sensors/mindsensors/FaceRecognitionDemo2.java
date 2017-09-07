package ev3dev.sensors.mindsensors;

import ev3dev.actuators.Sound;
import ev3dev.sensors.mindsensors.NXTCamV5;
import lejos.hardware.port.SensorPort;
import lejos.robotics.geometry.Rectangle2D;
import lejos.utility.Delay;

/**
 * Created by jabrena on 30/7/17.
 */
public class FaceRecognitionDemo2 {

    public static void main(String[] args){

        System.out.println("NXTCamV5 Face Recognition Demo");

        final NXTCamV5 camera = new NXTCamV5(SensorPort.S1);
        camera.setTrackingMode(NXTCamV5.FACE_TRACKING);

        for(int x = 0; x <= 100; x++){
            System.out.println("Iteration: " + x);

            int trackedObject = camera.getNumberOfObjects();
            System.out.println(trackedObject);

            if(trackedObject > 0) {
                Sound.getInstance().beep();
            }

            if(trackedObject > 0) {
                for(int y = 0; y < trackedObject; y++){
                    Rectangle2D rectangle = camera.getRectangle(y);
                    System.out.print("W: " + rectangle.getWidth() + " ");
                    System.out.print("H: " + rectangle.getHeight() + " ");
                    System.out.print("X: " + rectangle.getX() + " ");
                    System.out.print("Y: " + rectangle.getY() + "\n");
                }

                Sound.getInstance().beep();
            }

            Delay.msDelay(1000);
        }

    }
}
