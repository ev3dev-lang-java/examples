package lejos.navigation.mapping;


import java.io.IOException;

import lejos.robotics.geometry.Line;
import lejos.robotics.geometry.Rectangle;
import lejos.robotics.geometry.RectangularShape;
import lejos.robotics.mapping.LineMap;
import lejos.robotics.pathfinding.FourWayGridMesh;
import lejos.robotics.pathfinding.NodePathFinder;

public class CreateMapExample {

	public static void main(String[] args) {

		Line line1 = new Line(0, 0, 100, 100);
		Line line2 = new Line(100, 100, 200, 0);
		Line line3 = new Line(200, 0, 0, 0);
		Line[] linesArray = {line1,line2,line3};
		Rectangle boundingRect = new Rectangle(20, 20, 300, 300);
		LineMap  map = new LineMap(linesArray, boundingRect);

		FourWayGridMesh mesh = new FourWayGridMesh(map, 10, 0);

		try {
			map.flip().createSVGFile("map.svg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}