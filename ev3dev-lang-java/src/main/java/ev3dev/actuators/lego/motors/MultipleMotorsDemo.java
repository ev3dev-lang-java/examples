package ev3dev.actuators.lego.motors;

import ev3dev.hardware.EV3DevPlatform;
import ev3dev.hardware.EV3DevPlatforms;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class MultipleMotorsDemo extends EV3DevPlatforms {

    public static void main(String[] args) throws InterruptedException {

        MultipleMotorsDemo example = new MultipleMotorsDemo();

        System.out.println("Starting motor on A");
        final EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);
        System.out.println("Starting motor on B");
        final EV3MediumRegulatedMotor mB = new EV3MediumRegulatedMotor(MotorPort.B);

        if(example.getPlatform().equals(EV3DevPlatform.EV3BRICK)) {
            mA.brake();
            mB.brake();
        }

        mA.setSpeed(500);
        mA.forward();

        mB.setSpeed(500);
        mB.forward();

        Delay.msDelay(2000);
        mA.stop();
        mB.stop();
        System.out.println("Stopped motors");
    }

}
