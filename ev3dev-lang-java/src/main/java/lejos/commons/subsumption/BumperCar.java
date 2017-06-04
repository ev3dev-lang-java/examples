package lejos.commons.subsumption;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
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

        EV3UltrasonicSensor us1 = new EV3UltrasonicSensor(SensorPort.S1);

        Behavior b1 = new DriveForward(motorLeft, motorRight);
        Behavior b2 = new HitWall(motorLeft, motorRight, us1);
        Behavior [] bArray = {b1, b2};
        Arbitrator arby = new Arbitrator(bArray);
        arby.go();
    }
}
