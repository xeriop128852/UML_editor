package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


public class Group extends Shape {
	private List<Shape> shapes = new ArrayList<Shape>();
	private Rectangle bounds = new Rectangle();
	private Shape selectedShape = null;
	
	public Group(Graphics g) {
		for (int i = 0; i < shapes.size(); i++) {
			Shape shape = shapes.get(i);
			shape.drawPorts(g);
		}
	}

	@Override
	public void draw(Graphics g) {
		int alpha = 85; // 33% transparent
		int offset = 10;
		g.setColor(new Color(110, 219, 181, alpha));
		g.fillRect(bounds.x - offset, bounds.y - offset, bounds.width + offset * 2, bounds.height + offset * 2);
		g.setColor(new Color(110, 219, 181));
		g.drawRect(bounds.x - offset, bounds.y - offset, bounds.width + offset * 2, bounds.height + offset * 2);
		g.setColor(Color.white);
		if (selectedShape != null) {
			selectedShape.draw(g);
		}
	}

}
