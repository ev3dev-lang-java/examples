package ev3dev.actuators.lego.motors;

import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class UnregulatedMutilpleMotorDemo {

	//Robot Definition
	private static UnregulatedMotor umotor1 = new UnregulatedMotor(MotorPort.C);
	private static UnregulatedMotor umotor2 = new UnregulatedMotor(MotorPort.D);

    //Configuration
    private final static int motorPower = 50;
    private final static int ONE_SECOND = 1000;
	
	public static void main(String[] args) {

		//Set power for DC Motors
		umotor1.setPower(motorPower);
		umotor2.setPower(motorPower);
		
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

		//Testing DC-Motor 2
		umotor2.forward();
		System.out.println("" + umotor2.isMoving());
		Delay.msDelay(ONE_SECOND);
		umotor2.stop();
		System.out.println("" + umotor2.isMoving());
		umotor2.backward();
		System.out.println("" + umotor2.isMoving());
		Delay.msDelay(ONE_SECOND);
		umotor2.stop();
		System.out.println("" + umotor2.isMoving());
		umotor2.forward();
		System.out.println("" + umotor2.isMoving());
		Delay.msDelay(ONE_SECOND);
		umotor2.stop();

	}

}
