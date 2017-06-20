package ev3dev.actuators.lego.motors;

import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class UnregulatedMotorDemo {

	//Robot Definition
	private static UnregulatedMotor umotor1 = new UnregulatedMotor(MotorPort.C);

    //Configuration
    private final static int motorPower = 50;
    private final static int ONE_SECOND = 1000;
	
	public static void main(String[] args) {

		//Set power for DC Motors
		umotor1.setPower(motorPower);
		
		//Testing DC-Motor 1
		umotor1.forward();
		System.out.println("" + umotor1.isMoving());
		Delay.msDelay(ONE_SECOND);
		umotor1.stop();
		System.out.println("" + umotor1.isMoving());
		umotor1.backward();
		System.out.println("" + umotor1.isMoving());
		Delay.msDelay(ONE_SECOND);
		umotor1.stop();
		System.out.println("" + umotor1.isMoving());
		umotor1.forward();
		System.out.println("" + umotor1.isMoving());
		Delay.msDelay(ONE_SECOND);
		umotor1.stop();

	}

}
