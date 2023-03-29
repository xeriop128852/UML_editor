package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;


public class Group extends Shape {
	Point startP = new Point();
	Point endP = new Point();
	private List<Shape> shapes = new ArrayList<Shape>();
	private Rectangle bounds = new Rectangle();
	private List<Shape> shapesInGroup = new ArrayList<>();
	
	public Group(List<Shape> shapeList) {
		startP.x = shapeList.get(0).startP.x;
		endP.x = shapeList.get(0).endP.x;
		startP.y = shapeList.get(0).startP.y;
		endP.y = shapeList.get(0).endP.y;
		
		for(int i = 0; i < shapeList.size(); i++) {
			Shape shape = shapeList.get(i);
			shapesInGroup.add(shape);
			
			startP.x = Math.min(startP.x, shape.startP.x);
			startP.y = Math.min(startP.y, shape.startP.y);
			endP.x = Math.max(endP.x, shape.endP.x);
			endP.y = Math.max(endP.y, shape.endP.y);
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
	
	public void resetShapesInGroup() {
		shapesInGroup = null;
	}
	
	public void move(int offsetX, int offsetY) {
		this.startP.x += offsetX;
		this.startP.y += offsetY;
		this.endP = setEndLocation(startP, endP.x-startP.x+offsetX, endP.y-startP.y+offsetY);

		for(int i = 0; i< this.shapesInGroup.size(); i++){
			this.shapesInGroup.get(i).move(offsetX, offsetY);
		}
	}
	
	public boolean IsInside(Point p){
//		for(int i = 0; i< this.shapesInGroup.size(); i++){
//			if(this.shapesInGroup.get(i).IsInside(p))
//				return true;
//		}
//		return false;
		Rectangle r = new Rectangle();
		r.setBounds(startP.x, startP.y, endP.x-startP.x, endP.y-startP.y); 
		if (r.contains(p)) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public void draw(Graphics g) {
		for(int i = 0; i< this.shapesInGroup.size(); i++){
			this.shapesInGroup.get(i).draw(g);
		}
		int alpha = 15;
		g.setColor(new Color(24, 12, 132, alpha));
		g.fillRect(startP.x, startP.y, endP.x - startP.x, endP.y - startP.y);
		g.setColor(new Color(24, 12, 132));
		g.drawRect(startP.x, startP.y, endP.x - startP.x, endP.y - startP.y);
	}
}