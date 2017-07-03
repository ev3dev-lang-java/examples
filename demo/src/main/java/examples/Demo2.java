package examples;

/**
 * Demonstration of the Behavior subsumption classes.
 *
 * Requires a wheeled vehicle with two independently controlled
 * motors connected to motor ports B and C, and
 * an EV3 IR sensor connected to port 4;
 *
 * @author Brian Bagnall and Lawrie Griffiths, modified by Roger Glassey
 *
 */
/*
public class EV3BumperCar {
    static RegulatedMotor leftMotor;// = Motor.B;
    static RegulatedMotor rightMoto;//r = Motor.C;
    //static IRSensor sensor;

    // Use these definitions instead if your motors are inverted
    // static RegulatedMotor leftMotor = MirrorMotor.invertMotor(Motor.A);
    //static RegulatedMotor rightMotor = MirrorMotor.invertMotor(Motor.C);

    public static void main(String[] args) {

        leftMotor.resetTachoCount();
        rightMotor.resetTachoCount();
        leftMotor.rotateTo(0);
        rightMotor.rotateTo(0);
        leftMotor.setSpeed(400);
        rightMotor.setSpeed(400);
        leftMotor.setAcceleration(800);
        rightMotor.setAcceleration(800);
        //sensor = new IRSensor();
        //sensor.setDaemon(true);
        //sensor.start();
        Behavior b1 = new DriveForward();
        Behavior b2 = new DetectWall();
        Behavior[] behaviorList =
                {
                        b1, b2
                };
        Arbitrator arbitrator = new Arbitrator(behaviorList);
        arbitrator.go();
    }
}


class IRSensor extends Thread {
    EV3IRSensor ir = new EV3IRSensor(SensorPort.S4);
    SampleProvider sp = ir.getDistanceMode();
    public int control = 0;
    public int distance = 255;

    IRSensor() {

    }

    public void run() {
        while (true) {
            float [] sample = new float[sp.sampleSize()];
            control = ir.getRemoteCommand(0);
            sp.fetchSample(sample, 0);
            distance = (int)sample[0];
            System.out.println("Control: " + control + " Distance: " + distance);

        }

    }
}


class DriveForward implements Behavior {

    private boolean _suppressed = false;

    public boolean takeControl() {

        if (Button.readButtons() != 0)
        {
            _suppressed = true;
            EV3BumperCar.leftMotor.stop();
            EV3BumperCar.rightMotor.stop();
            System.out.println("Button pressed");
            if ((Button.waitForAnyPress() & Button.ID_ESCAPE) != 0) {
                System.exit(1);
            }
            System.out.println("Button pressed 2");
            System.out.println("Button released");
        }
        return true;  // this behavior always wants control.
    }

    public void suppress()
    {
        _suppressed = true;// standard practice for suppress methods
    }

    public void action()
    {
        _suppressed = false;
        //EV3BumperCar.leftMotor.forward();
        //EV3BumperCar.rightMotor.forward();
        while (!_suppressed)
        {
            //EV3BumperCar.leftMotor.forward();
            //EV3BumperCar.rightMotor.forward();
            switch(EV3BumperCar.sensor.control)
            {
                case 0:
                    EV3BumperCar.leftMotor.setSpeed(400);
                    EV3BumperCar.rightMotor.setSpeed(400);
                    EV3BumperCar.leftMotor.stop(true);
                    EV3BumperCar.rightMotor.stop(true);
                    break;
                case 1:
                    EV3BumperCar.leftMotor.setSpeed(400);
                    EV3BumperCar.rightMotor.setSpeed(400);
                    EV3BumperCar.leftMotor.forward();
                    EV3BumperCar.rightMotor.forward();
                    break;
                case 2:
                    EV3BumperCar.leftMotor.backward();
                    EV3BumperCar.rightMotor.backward();
                    break;
                case 3:
                    EV3BumperCar.leftMotor.setSpeed(200);
                    EV3BumperCar.rightMotor.setSpeed(200);
                    EV3BumperCar.leftMotor.forward();
                    EV3BumperCar.rightMotor.backward();
                    break;
                case 4:
                    EV3BumperCar.leftMotor.setSpeed(200);
                    EV3BumperCar.rightMotor.setSpeed(200);
                    EV3BumperCar.leftMotor.backward();
                    EV3BumperCar.rightMotor.forward();
                    break;


            }
            Thread.yield(); //don't exit till suppressed
        }
        //EV3BumperCar.leftMotor.stop(true);
        //EV3BumperCar.rightMotor.stop(true);
        //EV3BumperCar.leftMotor.
    }
}


class DetectWall implements Behavior
{

    public DetectWall()
    {
        //touch = new TouchSensor(SensorPort.S1);
        //sonar = new UltrasonicSensor(SensorPort.S3);
    }


    private boolean checkDistance()
    {

        int dist = EV3BumperCar.sensor.distance;
        if (dist < 30) {
            return true;
        } else {
            return false;
        }
    }

    public boolean takeControl()
    {
        return checkDistance();
    }

    public void suppress()
    {
        //Since  this is highest priority behavior, suppress will never be called.
    }

    public void action()
    {
        EV3BumperCar.leftMotor.rotate(-180, true);// start Motor.B rotating backward
        EV3BumperCar.rightMotor.rotate(-180);  // rotate C farther to make the turn
        if ((System.currentTimeMillis() & 0x1) != 0)
        {
            EV3BumperCar.leftMotor.rotate(-180, true);// start Motor.B rotating backward
            EV3BumperCar.rightMotor.rotate(180);  // rotate C farther to make the turn
        }
        else
        {
            EV3BumperCar.rightMotor.rotate(-180, true);// start Motor.B rotating backward
            EV3BumperCar.leftMotor.rotate(180);  // rotate C farther to make the turn
        }
    }

}
*/