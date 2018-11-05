package examples.actuators;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class LargeMotorDemo3 {

	//Robot Definition
	private static EV3LargeRegulatedMotor motor1 = new EV3LargeRegulatedMotor(MotorPort.A);

    //Configuration
    private final static int DELAY = 300;
    private final static int iterations = 90;
	
	public static void main(String[] args) {

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Emergency Stop");
			motor1.stop();
		}));

		motor1.resetTachoCount();
		motor1.coast();

		imperativeLoops();
		functionalLoops();

		motor1.stop();
	}

	private static void imperativeLoops() {

		int motorPower = 0;

		for(int x =0; x <= iterations; x++) {

			motorPower = 10 * x;
			motor1.setSpeed(motorPower);
			motor1.forward();
			LOGGER.info("Power: {}", motor1.getSpeed());

			Delay.msDelay(DELAY);
		}

		for(int x =iterations; x >= 0; x--) {

			motorPower = 10 * x;
			motor1.setSpeed(motorPower);
			motor1.forward();
			LOGGER.info("Power: {}", motor1.getSpeed());

			Delay.msDelay(DELAY);
		}

	}

	private static void functionalLoops() {

		IntStream.range(0, iterations)
				.forEach( (x) -> {

					motor1.setSpeed(10 * x);
					motor1.forward();
					LOGGER.info("Power: {}", motor1.getSpeed());

					Delay.msDelay(DELAY);
				});

		IntStream.range(0, iterations)
				.map(i -> 0 + (iterations - i))
				.forEach( (x) -> {

					motor1.setSpeed(10 * x);
					motor1.forward();
					LOGGER.info("Power: {}", motor1.getSpeed());

					Delay.msDelay(DELAY);
				});

	}

}
