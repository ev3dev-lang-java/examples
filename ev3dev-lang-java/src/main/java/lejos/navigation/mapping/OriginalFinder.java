package lejos.navigation.mapping;

import ev3dev.utils.PilotProps;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.geometry.Line;
import lejos.robotics.geometry.Rectangle;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.localization.PoseProvider;
import lejos.robotics.mapping.LineMap;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Pose;
import lejos.robotics.navigation.Waypoint;
import lejos.robotics.pathfinding.AstarSearchAlgorithm;
import lejos.robotics.pathfinding.FourWayGridMesh;
import lejos.robotics.pathfinding.NodePathFinder;
import lejos.robotics.pathfinding.PathFinder;

public class OriginalFinder {

        public static void main(String[] args) throws Exception {
                
                PilotProps pp = new PilotProps();
                pp.loadPersistentValues();
                float wheelDiameter = Float.parseFloat(pp.getProperty(PilotProps.KEY_WHEELDIAMETER, "4.65"));
                float trackWidth = Float.parseFloat(pp.getProperty(PilotProps.KEY_TRACKWIDTH, "18.50"));
                RegulatedMotor leftMotor = PilotProps.getMotor(pp.getProperty(PilotProps.KEY_LEFTMOTOR, "B"));
                RegulatedMotor rightMotor = PilotProps.getMotor(pp.getProperty(PilotProps.KEY_RIGHTMOTOR, "C"));
                boolean reverse = Boolean.parseBoolean(pp.getProperty(PilotProps.KEY_REVERSE,"false"));

                DifferentialPilot robot = new DifferentialPilot(wheelDiameter,trackWidth,leftMotor,rightMotor,reverse);
                
                // Create a rudimentary map:
                Line[] lines = new Line[3];
                lines [0] = new Line(75f, 100f, 100f, 100f);
                lines [1] = new Line(100, 100, 87, 75);
                lines [2] = new Line(87, 75, 75, 100);
                Rectangle bounds = new Rectangle(-50, -50, 250, 250);
                LineMap myMap = new LineMap(lines, bounds);
                
                // Use a regular grid of node points. Grid space = 20. Clearance = 15:
                FourWayGridMesh grid = new FourWayGridMesh(myMap, 10, 15);
                
                // Use A* search:
                AstarSearchAlgorithm alg = new AstarSearchAlgorithm();
                
                // Give the A* search alg and grid to the PathFinder:
                PathFinder pf = new NodePathFinder(alg, grid);
                PoseProvider posep = new OdometryPoseProvider(robot);
                
                Navigator nav = new Navigator(robot, posep) ;
                System.out.println("Planning path...");
                //nav.followPath(pf.startPathFinding(new Pose(0,0,0), new Waypoint(0, 50));
                nav.followPath(pf.findRoute(new Pose(0, 0, 0), new Waypoint(165, 50)));
                nav.waitForStop();
        }                
}