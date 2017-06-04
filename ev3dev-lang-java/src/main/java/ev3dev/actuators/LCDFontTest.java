package ev3dev.actuators;

import lejos.hardware.lcd.GraphicsLCD;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;

public @Slf4j class LCDFontTest {

    public static GraphicsLCD lcd = LCD.getInstance();

    public static void main(final String[] args){

        System.out.println("EV3 LCD Example");

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

        // Get all font family name in a String[]
        String[] fontNames = env.getAvailableFontFamilyNames();
        for (String fontName : fontNames) {
            log.info("Font: {}",fontName);
        }

        // Construct all Font instance (with font size of 1)
        Font[] fonts = env.getAllFonts();
        for (Font font : fonts) {
            log.info("Font: {}",font);
        }

        writeMessage("Hello World");
    }

    public static void writeMessage(final String message){
        lcd.setColor(lejos.robotics.Color.BLACK);
        lcd.drawString(message, 50,50, 0);
        lcd.refresh();
    }

    public static void clear(){
        lcd.setColor(lejos.robotics.Color.WHITE);
        lcd.fillRect(0,0, lcd.getWidth(), lcd.getHeight());
    }
}
