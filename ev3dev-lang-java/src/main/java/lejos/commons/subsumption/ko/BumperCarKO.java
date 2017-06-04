package lejos.commons.subsumption.ko;

import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class BumperCarKO {

    public static void main(String [] args) {

        //https://en.wikipedia.org/wiki/Subsumption_architecture
        System.out.println("Example using Subsumption architecture");

        Behavior b1 = new DriveForward();
        Behavior b2 = new HitWall();
        Behavior [] bArray = {b1, b2};
        Arbitrator arby = new Arbitrator(bArray);
        arby.go();

    }

}