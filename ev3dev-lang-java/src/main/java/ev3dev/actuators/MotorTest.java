package examples.actuators;

import ev3dev.actuators.lego.motors.Motor;
import lejos.robotics.RegulatedMotor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jabrena on 28/6/17.
 */
@Slf4j
public class MotorTest {

    public static void main(String[] args) throws Exception{

        RegulatedMotor motor = Motor.A;
        motor.resetTachoCount();
        motor.coast();

        LOGGER.info("{}", motor.getTachoCount());

    }

}
