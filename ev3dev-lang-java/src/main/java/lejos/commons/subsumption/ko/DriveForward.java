package lejos.commons.subsumption.ko;

import ev3dev.actuators.lego.motors.Motor;
import lejos.robotics.subsumption.*;

public class DriveForward  implements Behavior {

    private boolean suppressed = false;

    public boolean takeControl() {
    return true;
    }

    public void suppress() {
    suppressed = true;
    }

    public void action() {
        suppressed = false;
        Motor.A.forward();
        Motor.B.forward();
        while( !suppressed )
        Thread.yield();
        Motor.A.stop(); // clean up
        Motor.B.stop();
    }
}