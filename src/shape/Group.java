package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class Group extends BasicObj {
	public List<Shape> shapes = new ArrayList<Shape>();
	public List<Shape> shapesInGroup = new ArrayList<>();
	
	public Group(List<Shape> shapeList) {
		this.startP.x = Integer.MAX_VALUE;
		this.startP.y = Integer.MAX_VALUE;
		this.endP.x = Integer.MIN_VALUE;
		this.endP.y = Integer.MIN_VALUE;
		
		for(int i = 0; i < shapeList.size(); i++) {
			Shape shape = shapeList.get(i);
			shape.setSelected(false);
			shapesInGroup.add(shape);
			
			this.startP.x = Math.min(this.startP.x, shape.startP.x);
			this.startP.y = Math.min(this.startP.y, shape.startP.y);
			this.endP.x = Math.max(this.endP.x, shape.endP.x);
			this.endP.y = Math.max(this.endP.y, shape.endP.y);
		}
		
		width = endP.x - startP.x;
		height = endP.y - startP.y;
		generatePorts();
	}
	
	public void addShape(Shape shape) {
		shapesInGroup.add(shape);
	}
	
	public void removeShape(Shape shape) {
		this.shapesInGroup.remove(shape);
	}

	public List<Shape> getShapes() {
		return shapesInGroup;
	}
	
	public void resetShapesInGroup() {
		shapesInGroup = null;
	}
	
	public void setSelected(boolean b) {
		if(b == true) {
			this.isSelected = true;
			for(int i = 0; i < shapesInGroup.size(); i++) {
				shapesInGroup.get(i).setSelected(true);
			}
		}
		else {
			this.isSelected = false;
			for(int i = 0; i < shapesInGroup.size(); i++) {
				shapesInGroup.get(i).setSelected(false);
			}
		}
	}
	
	@Override
	public void move(int offsetX, int offsetY) {
		for(int i = 0; i< this.shapesInGroup.size(); i++){
			this.shapesInGroup.get(i).move(offsetX, offsetY);
		}
		this.startP.x += offsetX;
		this.startP.y += offsetY;
		this.endP = setEndLocation(endP, offsetX, offsetY);
		resetPorts(offsetX, offsetY);
	}
	
//	@Override
//	public boolean IsInside(Point p){
//		Rectangle r = new Rectangle();
//		r.setBounds(startP.x, startP.y, width, height); 
//		if (r.contains(p)) {
//			return true;
//		}
//		return false;
//	}
	
	
	@Override
	public void draw(Graphics g) {
		for(int i = 0; i< this.shapesInGroup.size(); i++){
			this.shapesInGroup.get(i).draw(g);
		}
		int alpha = 15;
		g.setColor(new Color(24, 12, 132, alpha));
		g.fillRect(this.startP.x, this.startP.y, width, height);
		g.setColor(new Color(24, 12, 132));
		g.drawRect(this.startP.x, this.startP.y, width, height);
	}
	
}
