package examples.actuators;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class UnregulatedMotorDemo4 {

	//Robot Definition
	private static EV3LargeRegulatedMotor umotor1 = new EV3LargeRegulatedMotor(MotorPort.A);

    //Configuration
    private final static int DELAY = 300;
	
	public static void main(String[] args) {

		umotor1.resetTachoCount();
		umotor1.suspendRegulation();
		umotor1.brake();

		imperativeLoops();
		functionalLoops();

		umotor1.stop();
	}

	private static void imperativeLoops() {

		int motorPower = 0;

		for(int x =0; x <= 10; x++) {

			motorPower = 10 * x;
			umotor1.setSpeed(motorPower);
			umotor1.forward();
			LOGGER.info("Power: {}", umotor1.getSpeed());

			Delay.msDelay(DELAY);
		}

		for(int x =10; x >= 0; x--) {

			motorPower = 10 * x;
			umotor1.setSpeed(motorPower);
			umotor1.forward();
			LOGGER.info("Power: {}", umotor1.getSpeed());

			Delay.msDelay(DELAY);
		}

	}

	private static void functionalLoops() {

		IntStream.range(0, 10)
				.forEach( (x) -> {

					umotor1.setSpeed(10 * x);
					umotor1.forward();
					LOGGER.info("Power: {}", umotor1.getSpeed());

					Delay.msDelay(DELAY);
				});

		IntStream.range(0, 10)
				.map(i -> 0 + (10 - i))
				.forEach( (x) -> {

					umotor1.setSpeed(10 * x);
					umotor1.forward();
					LOGGER.info("Power: {}", umotor1.getSpeed());

					Delay.msDelay(DELAY);
				});

	}

}
