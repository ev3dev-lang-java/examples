package examples.sensors;

import ev3dev.sensors.Button;
import ev3dev.sensors.EV3Key;
import lejos.hardware.Key;
import lejos.hardware.KeyListener;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ButtonListenersExample {

    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern(
            "HH:mm:ss.SSS");

    private static class MyKeyListener implements KeyListener {
        private final Key registeredForKey;

        public MyKeyListener(final Key registeredForKey) {
            this.registeredForKey = registeredForKey;
        }

        @Override
        public void keyPressed(final Key key) {
            LOGGER.info("%s - [%s listener] %s pressed%n", LocalTime.now().format(TIMESTAMP_FORMAT),
                    this.registeredForKey.getName(), key.getName());
        }
        @Override
        public void keyReleased(final Key key) {
            LOGGER.info("%s - [%s listener] %s released%n", LocalTime.now().format(TIMESTAMP_FORMAT),
                    this.registeredForKey.getName(), key.getName());
        }
    }

    private static final List<Key> BUTTONS_FOR_LISTENERS = Arrays.asList(new Key[] {
            Button.UP,
            Button.DOWN,
            new EV3Key(EV3Key.BUTTON_ALL)   // a special key that stands for 'any' key
    });

    public static void main(final String[] args){

        // registering the listeners
        LOGGER.info("Registering key listeners...");
        BUTTONS_FOR_LISTENERS.forEach((key) -> {
            key.addKeyListener(new MyKeyListener(key));
            LOGGER.info("Listener for %s key registered%n", key.getName());
        });

        // printing some on-screen help
        final Key exitButton = Button.ENTER;
        final Key anyButton = new EV3Key(EV3Key.BUTTON_ALL);
        final List<String> registeredKeyNamesExceptAll = BUTTONS_FOR_LISTENERS.stream()
                .filter((button) -> ! button.equals(anyButton))
                .map(Key::getName).collect(Collectors.toList());
        LOGGER.info("%nKeep pressing any buttons to see listeners getting key press/release events.%n");
        LOGGER.info("Notice that if you press or release one of the %s buttons, you'll get two events:%n", registeredKeyNamesExceptAll);
        LOGGER.info("  1) one for the listener registered on that specific key%n");
        LOGGER.info("  2) another one for the listener registered on the special %s key%n", anyButton.getName());

        // printing the key events (from the listeners) until the ESCAPE key is pressed (i.e. the call above blocks)
        LOGGER.info("%nPress the %s key to terminate the program...%n", exitButton.getName());
        exitButton.waitForPress();

        // terminating
        LOGGER.info("%n%s press detected, terminating the program.%n", exitButton.getName());
    }
}
