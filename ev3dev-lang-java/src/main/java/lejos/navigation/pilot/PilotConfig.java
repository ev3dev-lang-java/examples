package lejos.navigation.pilot;

import ev3dev.utils.PilotProps;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

import java.io.IOException;

public class PilotConfig {

    private DifferentialPilot pilot;

    public PilotConfig() throws IOException {

        PilotProps pp = new PilotProps();
        pp.loadPersistentValues();
        float wheelDiameter = Float.parseFloat(pp.getProperty(PilotProps.KEY_WHEELDIAMETER));
        float trackWidth = Float.parseFloat(pp.getProperty(PilotProps.KEY_TRACKWIDTH));
        RegulatedMotor leftMotor = PilotProps.getMotor(pp.getProperty(PilotProps.KEY_LEFTMOTOR));
        RegulatedMotor rightMotor = PilotProps.getMotor(pp.getProperty(PilotProps.KEY_RIGHTMOTOR));
        boolean reverse = Boolean.parseBoolean(pp.getProperty(PilotProps.KEY_REVERSE));

        //Special Stop modes from EV3Dev
        leftMotor.brake();
        rightMotor.brake();

        System.out.println("Any button to start");

        pilot = new DifferentialPilot(wheelDiameter, trackWidth, leftMotor, rightMotor, reverse);
        //pilot.setAngularAcceleration();
        pilot.setAngularSpeed(100);
        //pilot.setLinearAcceleration();
        pilot.setLinearSpeed(100);
        int accel = 60;
        //pilot.setAcceleration(accel);
    }

    public DifferentialPilot getPilot(){
        return pilot;
    }
}
