package ev3dev.sensors;

public class ButtonTest2 {

    public static void main(final String[] args){

        System.out.println("Demo");

        Button.UP.waitForPress();
        System.out.println("Pressed UP");

        Button.DOWN.waitForPress();
        System.out.println("Pressed DOWN");

        Button.LEFT.waitForPress();
        System.out.println("Pressed LEFT");

        Button.RIGHT.waitForPress();
        System.out.println("Pressed RIGHT");

        Button.ESCAPE.waitForPress();
        System.out.println("Pressed ESCAPE");

        Button.ENTER.waitForPress();
        System.out.println("Pressed ENTER");

    }
}
