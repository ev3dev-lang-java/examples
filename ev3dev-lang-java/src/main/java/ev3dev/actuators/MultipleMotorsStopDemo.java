package examples.actuators;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class MultipleMotorsStopDemo {

    public static void main(String[] args) {

        MultipleMotorsStopDemo example = new MultipleMotorsStopDemo();

        final EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);
        final EV3LargeRegulatedMotor mB = new EV3LargeRegulatedMotor(MotorPort.B);
        mA.stop();
        mB.stop();
        System.out.println("Stopped motors");
    }

}
