package examples.actuators;

import ev3dev.actuators.Sound;
import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class RegulatedMotorRotateToDemo {
	
    public static void main(String[] args) {

        Sound sound = Sound.getInstance();
    	
    	final int degreesToTurn = 90;
    	int currentDegrees =  0;

        EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);
        mA.resetTachoCount();
        mA.setSpeed(100);

        mA.brake();

        System.out.println("" + mA.getTachoCount());
        currentDegrees += degreesToTurn;
        System.out.println("" + currentDegrees);
        mA.rotateTo(currentDegrees);
        sound.beep();
        Delay.msDelay(1000);

        System.out.println("" + mA.getTachoCount());
        currentDegrees += degreesToTurn;
        System.out.println("" + currentDegrees);
        mA.rotateTo(currentDegrees);
        sound.beep();
        Delay.msDelay(1000);

    }
}
