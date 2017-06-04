package lejos.navigation.pilot;

import ev3dev.actuators.lego.motors.Motor;
import ev3dev.sensors.Battery;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Pose;
import lejos.utility.Delay;

public class DifferentialPilotTest9 {

   public static void main(String [] args) throws Exception {

       final double wheelDiameter = 8.2;
       final double trackWidth = 12.6;
       RegulatedMotor leftMotor = Motor.A;
       RegulatedMotor rightMotor = Motor.B;

       //Special Stop modes from EV3Dev
       leftMotor.brake();
       rightMotor.brake();

       DifferentialPilot pilot = new DifferentialPilot(
               wheelDiameter,
               trackWidth,
               leftMotor,
               rightMotor);

       //pilot.setAngularAcceleration();
       pilot.setAngularSpeed(100);
       //pilot.setLinearAcceleration();
       pilot.setLinearSpeed(100);

       OdometryPoseProvider poseProvider = new OdometryPoseProvider(pilot);

       Pose initialPose = new Pose(0,0,0);
       poseProvider.setPose(initialPose);

       System.out.println("Pilot square");
	   
       for(int i = 0; i < 4; i++) {
           pilot.travel(20);           
           show(poseProvider.getPose());
    	   Delay.msDelay(1000);
                      
           pilot.rotate(90);
           show(poseProvider.getPose());
           Delay.msDelay(1000);
       }
       
       pilot.stop();

       System.out.println("Program stopped");
       System.out.println("Voltage: {}" + Battery.getInstance().getVoltage());
   }

   private static void show(Pose p) {
       System.out.println("Pose X " + p.getX());
       System.out.println("Pose Y " + p.getY());
       System.out.println("Pose V " + p.getHeading());
   }

}