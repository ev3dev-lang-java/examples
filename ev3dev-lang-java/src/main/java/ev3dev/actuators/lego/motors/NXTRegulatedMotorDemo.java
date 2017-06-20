package ev3dev.actuators.lego.motors;

import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class NXTRegulatedMotorDemo {
	
    public static void main(String[] args) {

		System.out.println("Testing some features for a medium Motor");
        final RegulatedMotor mA = new NXTRegulatedMotor(MotorPort.A);
        mA.setSpeed(500);
        mA.brake();
      
        int ONE_SECOND = 1000;
 
        mA.forward();
		System.out.println("" + mA.isMoving());
		Delay.msDelay(ONE_SECOND);
		mA.stop();
		System.out.println("" + mA.isMoving());
		mA.backward();
		System.out.println("" + mA.isMoving());
		Delay.msDelay(ONE_SECOND);
		mA.stop();
		System.out.println("" + mA.isMoving());
		mA.forward();
		System.out.println("" +  mA.isMoving());
		Delay.msDelay(ONE_SECOND);
		mA.stop();
    }
}
