package examples;

import ev3dev.actuators.LCD;
import ev3dev.hardware.EV3DevDistro;
import ev3dev.hardware.EV3DevDistros;
import ev3dev.utils.Brickman;
import ev3dev.utils.JarResource;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.utility.Delay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

public class DisplayAnimations {

    public static Logger LOGGER = LoggerFactory.getLogger(DisplayAnimations.class);

    private static GraphicsLCD lcd = LCD.getInstance();

    private final HttpConnector connector;

    private BufferedImage image;

    public DisplayAnimations(HttpConnector httpConnector) {

        if(EV3DevDistros.getInstance().getDistro().equals(EV3DevDistro.JESSIE)) {
            Brickman.disable();
        }

        this.connector = httpConnector;

        try {
            image  = JarResource.loadImage(JarResource.JAVA_DUKE_IMAGE_NAME);

        }catch (IOException e){
            LOGGER.error(e.getLocalizedMessage());
        }

    }

    public void showJavaLogo() {

        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("Showing Java logo on EV3 Brick");
        }

        lcd.drawImage(image, 35, 10, 0);
        lcd.refresh();
    }

    public void sin() {

        for ( int i = 0; i <= lcd.getWidth(); i++ ) {
            int x = i;
            int y = 50 + (int) (Math.sin(i) * 5);

            clear();
            //lcd.setColor(Color.BLACK);
            lcd.setColor(0,0,0);
            lcd.fillRect(x, y, 20, 20);
            lcd.refresh();
            Delay.msDelay(10);
        }

        connector.pingLeft();
    }

    public void sin2() {

        for ( int i = lcd.getWidth()-20; i >= 0-20; i-- ) {
            int x = i;
            int y = 50 + (int) (Math.sin(i) * 5);

            clear();
            //lcd.setColor(Color.BLACK);
            lcd.setColor(0,0,0);
            lcd.fillRect(x, y, 20, 20);
            lcd.refresh();
            Delay.msDelay(10);
        }

        connector.pingRight();
    }

    public void clear(){
        //lcd.setColor(Color.WHITE);
        lcd.setColor(255,255,255);
        lcd.fillRect(0,0, lcd.getWidth(), lcd.getHeight());
    }

}
