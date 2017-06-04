package ev3dev.sensors;

public class ButtonTest3 {

    public static void main(final String[] args){

        System.out.println("Demo");

        EV3Key key = new EV3Key(EV3Key.BUTTON_UP);
        key.waitForPress();

        System.out.println("finished");

    }
}
