package examples.actuators;


import ev3dev.actuators.lego.motors.NXTRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.RegulatedMotorListener;
import lejos.utility.Delay;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MotorEventTest {

    public static void main(String[] args) {

        LOGGER.info("Testing events with Motors");

        // Listener to stop motors if they get stalled
        final RegulatedMotorListener listener = new RegulatedMotorListener() {

            @Override
            public void rotationStarted(
                    final RegulatedMotor motor,
                    final int tachoCount,
                    final boolean stalled,
                    final long timeStamp) {

                LOGGER.info("Started");
            }

            @Override
            public void rotationStopped(
                final RegulatedMotor motor,
                final int tachoCount,
                final boolean stalled,
                final long timeStamp) {

                LOGGER.info("Stopped");
            }
        };

        final RegulatedMotor mA = new NXTRegulatedMotor(MotorPort.A);
        mA.coast();

        mA.addListener(listener);

        mA.forward();
        Delay.msDelay(1500);
        mA.stop();

    }


}
