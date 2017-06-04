package lejos.navigation.pilot;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.sensors.Battery;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;

public class DifferentialPilotTest2 {

    public static void main(String[] args) {

		final double wheelDiameter = 8.2;
		final double trackWidth = 12.6;

        //TODO: How to do the same?
        //Special Stop modes from EV3Dev
        /*
		final DifferentialPilot pilot = new DifferentialPilot(
				wheelDiameter,
				trackWidth,
				new EV3LargeRegulatedMotor(MotorPort.A),
				new EV3LargeRegulatedMotor(MotorPort.B));
		*/

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
		final OdometryPoseProvider poseProvider = new OdometryPoseProvider(pilot);

        //pilot.setAngularAcceleration();
        pilot.setAngularSpeed(100);
        //pilot.setLinearAcceleration();
        pilot.setLinearSpeed(100);

		pilot.steer(0, 180);
		System.out.println("Heading: " + poseProvider.getPose().getHeading());
		pilot.steer(50, 180);
		System.out.println("Heading: " + poseProvider.getPose().getHeading());

		System.out.println("Voltage: {}" +  Battery.getInstance().getVoltage());
	}
}