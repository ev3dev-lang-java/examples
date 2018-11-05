package examples.actuators;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MotorEncoderTest {

    public static void main(String[] args) throws Exception{

        RegulatedMotor motor = new EV3LargeRegulatedMotor(MotorPort.A);
        motor.resetTachoCount();
        motor.coast();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        class MotorReader implements Runnable {
            private RegulatedMotor motor;

            public MotorReader(RegulatedMotor motor) {
                this.motor = motor;
            }

            public void run() {
                for (int x=1; x < 20; x++){

                    LOGGER.info("{} {}",x ,motor.getTachoCount());

                    Delay.msDelay(500);
                }
            }
        }

        class MotorWriter implements Runnable {
            private RegulatedMotor motor;

            public MotorWriter(RegulatedMotor motor) {
                this.motor = motor;
            }

            public void run() {
                for (int x=1; x < 20; x++){


                    int random = randomWorldNumber();
                    LOGGER.info("{}", random);

                    int firstDigit = Integer.parseInt(Integer.toString(random).substring(0, 1));
                    if(firstDigit > 5) {
                        motor.stop();
                        motor.forward();
                    }else {
                        motor.stop();
                        motor.backward();
                    }

                    Delay.msDelay(1500);
                }
            }
        }

        executor.execute(new MotorReader(motor));
        executor.execute(new MotorWriter(motor));
        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();

        motor.stop();

        System.exit(0);
    }

    private static int randomWorldNumber() {
        return 1 + ThreadLocalRandom.current().nextInt(10000);
    }


}
