package examples.sensors;

import ev3dev.sensors.Button;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ButtonExample {

    public static void main(final String[] args){

        LOGGER.info("Button example");

        Button.waitForAnyPress();

        LOGGER.info("Button pressed");
    }
}