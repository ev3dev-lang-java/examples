package ev3dev.actuators.lego.motors;

import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class MediumMotorStopModesExample {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting motors on A");
        final EV3MediumRegulatedMotor mA = new EV3MediumRegulatedMotor(MotorPort.A);
        mA.setSpeed(500);

        System.out.println("Testing brake stop mode");
        mA.brake();
        mA.forward();
        System.out.println(String.format("Large Motor is moving: %s at speed %d", mA.isMoving(), mA.getSpeed()));
        Delay.msDelay(2000);
        mA.stop();

        Delay.msDelay(2000);

        System.out.println("Testing hold stop mode");
        mA.hold();
        mA.forward();
        System.out.println(String.format("Large Motor is moving: %s at speed %d", mA.isMoving(), mA.getSpeed()));
        Delay.msDelay(2000);
        mA.stop();

        Delay.msDelay(2000);

        System.out.println("Testing coast stop mode");
        mA.coast();
        mA.forward();
        System.out.println(String.format("Large Motor is moving: %s at speed %d", mA.isMoving(), mA.getSpeed()));
        Delay.msDelay(2000);
        mA.stop();

        System.out.println("Stopped motors");
    }

}
