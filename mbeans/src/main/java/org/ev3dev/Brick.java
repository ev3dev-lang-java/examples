package org.ev3dev;

import ev3dev.actuators.Sound;
import ev3dev.sensors.Battery;

public class Brick implements BrickMBean {

    @Override
    public float getBatteryVoltage() {
        return Battery.getInstance().getVoltage();
    }

    @Override
    public void beep() {
        Sound.getInstance().beep();
    }

}