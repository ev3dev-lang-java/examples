package examples;

import ev3dev.sensors.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Demo {

    public static Logger LOGGER = LoggerFactory.getLogger(Demo.class);

    private static DisplayAnimations displayAnimations;

    private static HttpConnector connector;

    public static void main(String[] args) throws IOException {

        String anotherIP = "";
        if (args.length > 0) {
            anotherIP = args[0];
            LOGGER.info(anotherIP);
        }else {
            throw new RuntimeException("No parameter");
        }

        connector = new HttpConnector(anotherIP);

        displayAnimations = new DisplayAnimations(connector);
        displayAnimations.showJavaLogo();

        //Button.LEFT.addKeyListener(
        //        new MyKeyListener(Button.LEFT, displayAnimations));
        //Button.RIGHT.addKeyListener(
        //        new MyKeyListener( Button.RIGHT, displayAnimations));
        Button.ENTER.addKeyListener(
                new MyKeyListener( Button.ENTER, displayAnimations));

        //Web Interface
        new WebControl(displayAnimations).run();
    }

}