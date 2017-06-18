package ev3dev.misc;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.Battery;
import ev3dev.sensors.ev3.EV3IRSensor;
import ev3dev.utils.JarResource;
import ev3dev.utils.Shell;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

import java.util.ArrayList;
import java.util.List;

public class BumperCar {
	
	//Robot Definition
    private final static EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);
    private final static EV3LargeRegulatedMotor mB = new EV3LargeRegulatedMotor(MotorPort.B);
    private final static EV3IRSensor ir1 = new EV3IRSensor(SensorPort.S1);

    //Configuration
    private final static int motorSpeed = 200;
    
    public static void main(String[] args) {

        //To Stop the motor in case of pkill java for example
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                mA.stop();
                mB.stop();
            }
        }));

        mA.setSpeed(motorSpeed);
        mB.setSpeed(motorSpeed);

        final SampleProvider sp = ir1.getDistanceMode();
        int distance = 255;

        final int distance_threshold = 35;
        
        //Robot control loop
        final int iteration_threshold = 400;
        for(int i = 0; i <= iteration_threshold; i++) {
        	forward();

            float [] sample = new float[sp.sampleSize()];
            sp.fetchSample(sample, 0);
            distance = (int)sample[0];

            if(distance <= distance_threshold){
                System.out.println("Detected obstacle");
            	backwardWithTurn();
            }

        	System.out.println("Iteration: " + i);
            System.out.println("Battery: " + Battery.getInstance().getVoltage());
            System.out.println("Distance: " + distance);
            System.out.println();
        }

        mA.stop();
        mB.stop();
        System.exit(0);
    }
    
    private static void forward(){
        mA.forward();
        mB.forward();
    }
    
    private static void backwardWithTurn(){
        mA.backward();
        mB.backward();
        Delay.msDelay(1000);
        mA.stop();
        mB.stop();
        mA.backward();
        mB.forward();
        Delay.msDelay(1000);
        mA.stop();
        mB.stop();
    }

}
