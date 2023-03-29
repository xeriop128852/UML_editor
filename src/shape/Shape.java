package shape;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
	Point location;
	int depth = 0;
	boolean isSelected = false;
	boolean isGroup = false;

	public abstract void draw(Graphics g);;
	
	public Point getLocation() {
		return location;
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
}
