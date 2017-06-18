package lejos.commons.subsumption;

import ev3dev.sensors.ev3.EV3IRSensor;
import ev3dev.sensors.ev3.EV3UltrasonicSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;

public class HitWall implements Behavior {

    private boolean suppressed = false;

    private final RegulatedMotor motorLeft;
    private final RegulatedMotor motorRight;
    private final EV3IRSensor irSensor;

    public HitWall(
            final RegulatedMotor motorLeft,
            final RegulatedMotor motorRight,
            final EV3IRSensor irSensor) {
        this.motorLeft = motorLeft;
        this.motorRight = motorRight;
        this.irSensor = irSensor;
    }

    public boolean takeControl() {
        SampleProvider sp = irSensor.getDistanceMode();
        float [] sample = new float[sp.sampleSize()];
        sp.fetchSample(sample, 0);
        int distanceValue = (int)sample[0];

        return distanceValue < 30;
    }

    public void suppress() {
    suppressed = true;
    }

    public void action() {
        suppressed = false;
        motorLeft.rotate(-180, true);
        motorRight.rotate(-360, true);

        while( motorRight.isMoving() && !suppressed )
        Thread.yield();

        motorLeft.stop();
        motorRight.stop();
    }
}