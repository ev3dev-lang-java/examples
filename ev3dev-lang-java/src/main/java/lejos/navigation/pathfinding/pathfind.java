package lejos.navigation.pathfinding;


import lejos.robotics.geometry.Line;
import lejos.robotics.geometry.Rectangle;
import lejos.robotics.mapping.LineMap;
import lejos.robotics.pathfinding.ShortestPathFinder;
import lejos.robotics.navigation.Pose;
import lejos.robotics.navigation.Waypoint;

public class pathfind {
    public static Line[] course = {
		new Line(-40,-40,-40,100),
		new Line(-40,100,20,100),
		new Line(20,100,20,80),
		new Line(20,80,80,80),			//the barriers that the robot will avoid
		new Line(80,80,80,120),
		new Line(80,120,120,120),
		new Line(120,120,120,80),
		new Line(120,80,160,80),
		new Line(160,80,160,-40),
		new Line(160,-40,-40,-40),
		//first box
		new Line(20,20,20,60),
		new Line(20,60,40,60),
		new Line(40,60,40,20),
		new Line(40,20,20,20),
		//second box
		new Line(60,20,60,60),
		new Line(60,60,80,60),
		new Line(80,60,80,20),
		new Line(80,20,60,20),
		//third box
		new Line(100,20,100,60),
		new Line(100,60,120,60),
		new Line(120,60,120,20),
		new Line(120,20,100,20),
	};
	public static Pose start_node = new Pose(0,0,180);					//start position
	public static Pose final_node = new Pose(100,100,90);					//end position
	public static Waypoint end_node_waypoint = new Waypoint(final_node);	//create waypoint from end position
	public static Rectangle frame = new Rectangle(150,150,200,200);			//surrounding frame of map
	public static LineMap psuedo_map = new LineMap(course,frame);			//create line map from array lines and frame
	public static ShortestPathFinder captain = new ShortestPathFinder(psuedo_map);

	public static void main (String[] args) {
		pathfind start = new pathfind();
		try {
			captain.findRoute(start_node,end_node_waypoint);
		}
		catch (Exception error) {
			System.out.println("Destination in unreachable");
		}
	}
}