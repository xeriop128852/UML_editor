package shape;

import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape{
	protected Point startP = this.location;
	protected Point endP = null;
	
	private Shape startObj = null;
	private Shape endObj = null;
	
	public Line(Point start, Point end) {
		startP = start;
		endP = end;
	}
	
	
	
	@Override
	public void draw(Graphics g) {
	}

	public void setConnectedObj(Shape start, Shape end) {
		startObj = start;
		endObj = end;
	}
	
	public Shape getStartObj() {
		return this.startObj;
	}

	public Shape getEndObj() {
		return this.endObj;
	}
}
