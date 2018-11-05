package examples.sensors;

import ev3dev.sensors.Button;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ButtonExample2 {

    public static void main(final String[] args){
        LOGGER.info("Extended Button Example");

        LOGGER.info("Press UP");
        Button.UP.waitForPress();
        LOGGER.info("Pressed UP");

        LOGGER.info("Press DOWN");
        Button.DOWN.waitForPress();
        LOGGER.info("Pressed DOWN");

        LOGGER.info("Press LEFT");
        Button.LEFT.waitForPress();
        LOGGER.info("Pressed LEFT");

        LOGGER.info("Press RIGHT");
        Button.RIGHT.waitForPress();
        LOGGER.info("Pressed RIGHT");

        //Brick run use ESCAPE button to exit the program
        //LOGGER.info("Press ESCAPE");
        //Button.ESCAPE.waitForPress();
        //LOGGER.info("Pressed ESCAPE");

        LOGGER.info("Press ENTER");
        Button.ENTER.waitForPress();
        LOGGER.info("Pressed ENTER");

    }
}