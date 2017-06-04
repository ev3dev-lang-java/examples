package lejos.navigation.pilot;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.Battery;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class DifferentialPilotTest1 {

    public static void main(final String[] args){

        final double wheelDiameter = 8.2;
        final double trackWidth = 12.6;

        final RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
        final RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.B);

        //Special Stop modes from EV3Dev
        leftMotor.brake();
        rightMotor.brake();

        final DifferentialPilot pilot = new DifferentialPilot(
                wheelDiameter,
                trackWidth,
                leftMotor,
                rightMotor);

        //pilot.setAngularAcceleration();
        pilot.setAngularSpeed(100);
        //pilot.setLinearAcceleration();
        pilot.setLinearSpeed(100);

        pilot.travel(20);
        pilot.rotate(90);

        System.out.println("Voltage: {}" + Battery.getInstance().getVoltage());

    }
}
