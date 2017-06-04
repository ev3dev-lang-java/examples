package ev3dev.actuators.lego.motors;

import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class MediumMotorDemo {
	
    public static void main(String[] args) {

		System.out.println("Testing some features for a medium Motor");
        final EV3MediumRegulatedMotor mA = new EV3MediumRegulatedMotor(MotorPort.A);
        //mA.setSpeed(500);
      
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
