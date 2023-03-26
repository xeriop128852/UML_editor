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
	
	public boolean IsSelected() {
		return isSelected;
	}
	public boolean IsGroup() {
		return isGroup;
	}
	
	public void setSelected(boolean b) {
		isSelected = b;
	}
	public void setGroup(boolean b) {
		isGroup = b;
	}
}
