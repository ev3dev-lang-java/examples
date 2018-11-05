package examples.actuators;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;


public class MultipleMotorsDemo {

    public static void main(String[] args) throws InterruptedException {

        MultipleMotorsDemo example = new MultipleMotorsDemo();

        System.out.println("Starting motor on A");
        final EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);
        System.out.println("Starting motor on B");
        final EV3LargeRegulatedMotor mB = new EV3LargeRegulatedMotor(MotorPort.B);

        //To Stop the motor in case of pkill java for example
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            mA.stop();
            mB.stop();
        }));

        mA.brake();
        mB.brake();

        mA.setSpeed(100);
        mB.setSpeed(100);
        mA.forward();
        mB.forward();

        Delay.msDelay(4000);
        mA.stop();
        mB.stop();
        System.out.println("Stopped motors");
    }

}
