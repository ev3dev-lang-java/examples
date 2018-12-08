package examples;

import lejos.hardware.Key;
import lejos.hardware.KeyListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyKeyListener implements KeyListener {

    public static Logger LOGGER = LoggerFactory.getLogger(MyKeyListener.class);

    private final Key registeredForKey;

    private final DisplayAnimations displayAnimations;

    public MyKeyListener(
            final Key registeredForKey,
            final DisplayAnimations displayAnimations) {
        this.registeredForKey = registeredForKey;
        this.displayAnimations = displayAnimations;
    }

    @Override
    public void keyPressed(final Key key) {
        LOGGER.info("PRESSED");

        if(key.getName().equals("LEFT")){
            displayAnimations.sin();
            displayAnimations.clear();

        } else if (key.getName().equals("RIGHT")){
            displayAnimations.sin2();
            displayAnimations.clear();
        } else {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(final Key key) {

    }
}