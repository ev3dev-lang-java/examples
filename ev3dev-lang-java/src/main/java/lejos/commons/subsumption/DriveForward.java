package lejos.commons.subsumption;

import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;

public class DriveForward  implements Behavior {

    private boolean suppressed = false;

    private final RegulatedMotor motorLeft;
    private final RegulatedMotor motorRight;

    public DriveForward(
            final RegulatedMotor motorLeft,
            final RegulatedMotor motorRight) {
        this.motorLeft = motorLeft;
        this.motorRight = motorRight;
    }

    public boolean takeControl() {
    return true;
    }

    public void suppress() {
    suppressed = true;
    }

    public void action() {
        suppressed = false;
        motorLeft.forward();
        motorRight.forward();
        while( !suppressed )
        Thread.yield();
        motorLeft.stop(); // clean up
        motorRight.stop();
    }
}