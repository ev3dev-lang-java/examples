package examples;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.actuators.lego.motors.EV3MediumRegulatedMotor;
import ev3dev.sensors.Battery;
import ev3dev.sensors.ev3.EV3GyroSensor;
import ev3dev.sensors.slamtec.RPLidarA1;
import ev3dev.sensors.slamtec.model.Scan;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lombok.extern.slf4j.Slf4j;

public @Slf4j class DemoStop {

    private static EV3LargeRegulatedMotor mA = null;
    private static EV3MediumRegulatedMotor mB = null;

    private static EV3GyroSensor gyroSensor = null;
    private static Battery battery;
    private static final float VOLTAGE_THRESHOLD = 8000;

    private static final String USBPort = "/dev/ttyUSB0";
    private static RPLidarA1 lidar = null;

    public static void main(String[] args) throws Exception {

        mA = new EV3LargeRegulatedMotor(MotorPort.A);
        mB = new EV3MediumRegulatedMotor(MotorPort.B);
        mA.setSpeed(500);
        mB.setSpeed(500);

        mA.stop();
        mB.stop();
        System.exit(0);

        gyroSensor = new EV3GyroSensor(SensorPort.S1);
        final SampleProvider sp = gyroSensor.getAngleAndRateMode();
        battery = Battery.getInstance();
        lidar = new RPLidarA1(USBPort);
        lidar.init();

        while(battery.getVoltage() >= VOLTAGE_THRESHOLD) {

            final Scan scan = lidar.scan();
            long counter = scan.getDistances()
                    .stream()
                    .filter(measure -> {
                        if((measure.getAngle() >= 345) || (measure.getAngle() <=15)) {
                            if(measure.getDistance() <= 50) {
                                return true;
                            }
                            return false;
                        }
                        return false;
                    })
                    .count();

            if(counter < 5){
                mA.forward();
                mB.forward();
            }else{
                mA.stop();
                mB.stop();
                mA.setSpeed(200);
                mA.forward();

                //Control loop
                while(true){
                    float [] sample = new float[sp.sampleSize()];
                    sp.fetchSample(sample, 0);
                    int value = (int)sample[0];

                    log.info("Gyro angle/rate: {}", value);

                    if(value >= 45){
                        log.info("Rotated 45 degrees");
                        mA.stop();
                        break;
                    }

                }
            }

        }

        Delay.msDelay(2000);
        mA.stop();
        mB.stop();
        System.exit(0);
    }

}
