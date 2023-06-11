package shape;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
	protected Point startP, endP;
	protected boolean isSelected = false;
	
	public abstract void draw(Graphics g);
	public void move(int offsetX, int offsetY) {}
	
	
	public Point getStartLocation() {
		return startP;
	}
	public Point getEndLocation() {
		return endP;
	}
	
	public Point setEndLocation(Point start, int x, int y) {
		Point point = new Point(start.x + x, start.y + y);
		return point;
	}
	
	
	public boolean IsSelected() {
		return isSelected;
	}
	public void setSelected(boolean b) {
		isSelected = b;
	}
	
	//BasicObj
	public void addLine(Line line) {}
	public void drawPorts(Graphics g) {}
	public boolean IsInside(Point p) {return false;}
	
}
