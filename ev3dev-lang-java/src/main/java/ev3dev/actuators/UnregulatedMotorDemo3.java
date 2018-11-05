package examples.actuators;

import ev3dev.actuators.lego.motors.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class UnregulatedMotorDemo3 {

	//Robot Definition
	private static UnregulatedMotor umotor1 = new UnregulatedMotor(MotorPort.C);

    //Configuration
    private final static int DELAY = 300;
	
	public static void main(String[] args) {

		int motorPower = 0;

		IntStream.range(0, 10).forEach( (x) -> {

			umotor1.setPower(10 * x);
			umotor1.forward();
			LOGGER.info("Power: {}", umotor1.getPower());

			Delay.msDelay(DELAY);
		});

		for(int x =10; x >= 0; x--) {

			motorPower = 10 * x;
			umotor1.setPower(motorPower);
			umotor1.forward();
			LOGGER.info("Power: {}", umotor1.getPower());

			Delay.msDelay(DELAY);
		}

		umotor1.stop();
	}

}
