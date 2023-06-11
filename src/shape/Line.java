package shape;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Line extends Shape{
	private Shape startObj = null;
	private Shape endObj = null;
	
	public Line(Point start, Point end) {
		startP = start;
		endP = end;
	}
	
	public abstract void draw(Graphics g);

	public Shape getStartObj() {
		return this.startObj;
	}

	public Shape getEndObj() {
		return this.endObj;
	}
	
	public void setConnectedObj(Shape start, Shape end) {
		startObj = start;
		endObj = end;
	}
	public void currentPoint(Point p) {
        this.endP = p;
    }

	public void move(Shape shape, int offsetX, int offsetY) {
		if(shape == this.startObj){
			this.startP.x += offsetX;
			this.startP.y += offsetY;
		}
		else if(shape == this.endObj){
			this.endP.x += offsetX;
			this.endP.y += offsetY;
		}
	}


}
