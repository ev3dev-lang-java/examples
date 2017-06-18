package lejos.commons.subsumption;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.ev3.EV3IRSensor;
import ev3dev.sensors.ev3.EV3UltrasonicSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class BumperCar {

    public static void main(String [] args) {

        //https://en.wikipedia.org/wiki/Subsumption_architecture
        System.out.println("Example using Subsumption architecture");

        System.out.println("Starting motor on A");
        final RegulatedMotor motorLeft = new EV3LargeRegulatedMotor(MotorPort.A);
        System.out.println("Starting motor on B");
        final RegulatedMotor motorRight = new EV3LargeRegulatedMotor(MotorPort.B);

        final int motorSpeed = 200;
        motorLeft.setSpeed(motorSpeed);
        motorRight.setSpeed(motorSpeed);

        //To Stop the motor in case of pkill java for example
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                motorLeft.stop();
                motorRight.stop();
            }
        }));

        EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1);

        Behavior b1 = new DriveForward(motorLeft, motorRight);
        Behavior b2 = new HitWall(motorLeft, motorRight, irSensor);
        Behavior [] bArray = {b1, b2};
        Arbitrator arby = new Arbitrator(bArray);
        arby.go();

    }
}
