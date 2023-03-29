package mode;

import java.awt.event.MouseEvent;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import shape.Shape;

public class selectMode extends Mode {
	//protected Canvas canvas;
	private Point clickPoint = null;
	private List<Shape> shapes = new ArrayList<Shape>();;
	private Shape shape = null;
	
	public selectMode() {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.canvas.reset();
		shape = null;
		this.clickPoint = e.getPoint();
		this.shapes = canvas.getShapeList();
		
		for(int i = shapes.size()-1; i >= 0; i--) {
			
			if(shapes.get(i).IsInside(clickPoint)) {
				shape = shapes.get(i);
				canvas.setSelectedObj(shape);
				break;
			}
		}
		
		canvas.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(clickPoint != null){
			if(this.shape != null){
				int offsetX = e.getX() - (int)this.clickPoint.getX();
				int offsetY = e.getY() - (int)this.clickPoint.getY();
				this.clickPoint = e.getPoint();
				this.shape.move(offsetX, offsetY);	
			}
			
			this.canvas.repaint();
		}

	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		this.clickPoint = null;
		this.shape = null;
		//this.canvas.resetSelectedArea();
		this.canvas.repaint();
		
		
	}



}
