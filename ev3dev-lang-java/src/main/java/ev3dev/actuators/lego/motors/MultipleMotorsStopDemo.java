package ev3dev.actuators.lego.motors;

import ev3dev.hardware.EV3DevPlatforms;
import lejos.hardware.port.MotorPort;

public class MultipleMotorsStopDemo extends EV3DevPlatforms {

    public static void main(String[] args) throws InterruptedException {

        MultipleMotorsStopDemo example = new MultipleMotorsStopDemo();

        final EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);
        final EV3LargeRegulatedMotor mB = new EV3LargeRegulatedMotor(MotorPort.B);
        mA.stop();
        mB.stop();
        System.out.println("Stopped motors");
    }

}
