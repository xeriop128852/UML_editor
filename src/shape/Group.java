package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


public class Group extends Shape {
	private List<Shape> shapes = new ArrayList<Shape>();
	private Rectangle bounds = new Rectangle();
	private List<Shape> shapesInGroup = new ArrayList<>();
	
	public Group(List<Shape> shapeList) {
		for(int i = 0; i < shapeList.size(); i++) {
			Shape shape = shapeList.get(i);
			shapesInGroup.add(shape);
			
			if(i == 0) {
				startP = shape.startP;
				endP = shape.endP;
			}
			startP.x = Math.min(startP.x, shape.startP.x);
			startP.y = Math.min(startP.x, shape.startP.x);
			endP.x = Math.max(endP.x, shape.endP.x);
			endP.y = Math.max(endP.x, shape.endP.x);
		}
	}

	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void removeShape(Shape shape) {
		this.shapes.remove(shape);
	}

	public List<Shape> getShapes() {
		return shapes;
	}
	
	public void resetSelectedShape() {
		shapesInGroup = null;
	}
	@Override
	public void draw(Graphics g) {
		for(int i = 0; i< this.shapesInGroup.size(); i++){
			this.shapesInGroup.get(i).draw(g);
		}
	}

}
