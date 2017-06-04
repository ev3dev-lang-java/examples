package ev3dev.actuators.lego.motors;


import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.RegulatedMotorListener;
import lejos.utility.Delay;

public class MotorEventTest {

    public static void main(String[] args) {

        System.out.println("Testing events with Motors");

        // Listener to stop motors if they get stalled
        final RegulatedMotorListener listener = new RegulatedMotorListener() {

            @Override
            public void rotationStarted(
                    final RegulatedMotor motor,
                    final int tachoCount,
                    final boolean stalled,
                    final long timeStamp) {

                System.out.println("Started");
            }

            @Override
            public void rotationStopped(
                final RegulatedMotor motor,
                final int tachoCount,
                final boolean stalled,
                final long timeStamp) {

                System.out.println("Stopped");
            }
        };

        final RegulatedMotor mA = new NXTRegulatedMotor(MotorPort.A);
        mA.addListener(listener);
        mA.forward();
        Delay.msDelay(500);
        mA.stop();

    }


}
