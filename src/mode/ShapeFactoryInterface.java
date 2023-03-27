package mode;
import java.awt.Point;

import shape.BasicObj;
//import shape.Line;

public interface ShapeFactoryInterface {
	public BasicObj createObj(String objType, Point p);
	//public Line createLine(String lineType, Point startP, Point endP);
}