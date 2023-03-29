package shape;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Shape {
	Point startP, endP;
	int depth = 0;
	boolean isSelected = false;
	boolean isGroup = false;
	protected int width, height;
	public abstract void draw(Graphics g);;
	
	public Point getStartLocation() {
		return startP;
	}
	public Point setEndLocation(Point p, int x, int y) {
		Point point = new Point(p.x+x, p.y+y);
		return point;
	}
	public Point getEndLocation() {
		return endP;
	}
	public Point getPort(Point p) {
		return null;
	}
	
	public void move(int offsetX, int offsetY){}
	
	public boolean IsSelected() {
		return isSelected;
	}
	public boolean IsGroup() {
		return isGroup;
	}
	public boolean IsInside(Point p) {
		return false;
	}
	
	public void setSelected(boolean b) {
		isSelected = b;
	}
	public void setGroup(boolean b) {
		isGroup = b;
	}

	// BasicObj
	public void addLine(Line line) {
	}

	public void drawPorts(Graphics g) {}
	
}
