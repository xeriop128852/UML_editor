package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import shape.Shape;
import shape.BasicObj;

public class createLineMode extends Mode {
	private Point clickPoint = null;
	private List<Shape> shapes = new ArrayList<Shape>();;
	private Shape shape = null;
	private Shape startObj = null;
	private Shape endObj = null;
	
	public createLineMode(String str) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		shapes = canvas.getShapeList();
		clickPoint = e.getPoint();
		
		for(int i = shapes.size()-1; i >= 0; i--) {
			shape = shapes.get(i);
			if( (shape instanceof BasicObj) && shape.IsInside(clickPoint)) {
				this.startObj = (BasicObj) shape;
				
				break;
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
