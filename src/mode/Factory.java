package mode;

import java.awt.Point;

import shape.BasicObj;
import shape.Line;

public interface Factory {
	public BasicObj createBasicObj(String type, Point startP);
	public Line createLine(String type, Point startP, Point endP);
}
