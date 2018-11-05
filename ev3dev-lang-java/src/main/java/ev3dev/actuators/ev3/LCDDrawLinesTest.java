package examples.actuators.ev3;

import ev3dev.actuators.LCD;
import ev3dev.hardware.EV3DevDistro;
import ev3dev.hardware.EV3DevDistros;
import ev3dev.utils.Brickman;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.utility.Delay;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LCDDrawLinesTest {


    public static void main(final String[] args) {


        if(EV3DevDistros.getInstance().getDistro().equals(EV3DevDistro.JESSIE)) {
            Brickman.disable();
        }

        LOGGER.info("EV3 LCD Example");

        GraphicsLCD lcd = LCD.getInstance();

        lcd.clear();
        lcd.setColor(0, 0, 0);
        lcd.drawLine(0, 0, 50, 50);
        lcd.drawLine(0, 0, 30, 60);
        lcd.refresh();

        Delay.msDelay(5000);
    }
}
