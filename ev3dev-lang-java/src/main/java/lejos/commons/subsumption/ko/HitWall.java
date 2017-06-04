package lejos.commons.subsumption.ko;

import ev3dev.actuators.lego.motors.Motor;
import ev3dev.sensors.ev3.EV3UltrasonicSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.*;

public class HitWall implements Behavior {

    private EV3UltrasonicSensor sonar;
    private boolean suppressed = false;

    public HitWall() {
        sonar = new EV3UltrasonicSensor(SensorPort.S1);
    }

    public boolean takeControl() {
        SampleProvider sp = sonar.getDistanceMode();
        float [] sample = new float[sp.sampleSize()];
        sp.fetchSample(sample, 0);
        int distanceValue = (int)sample[0];

        return distanceValue < 25;
    }

    public void suppress() {
    suppressed = true;
    }

    public void action() {
        suppressed = false;
        Motor.A.rotate(-180, true);
        Motor.B.rotate(-360, true);

        while( Motor.B.isMoving() && !suppressed )
        Thread.yield();

        Motor.A.stop();
        Motor.B.stop();
    }
}