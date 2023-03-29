package mode;

import java.awt.event.MouseEvent;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import shape.Line;
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
			int offsetX = e.getX() - this.clickPoint.x;
			int offsetY = e.getY() - this.clickPoint.y;
			if(this.shape != null){
				
				this.clickPoint = e.getPoint();
				this.shape.move(offsetX, offsetY);	
			}
			else{
				if(offsetX > 0 )
					if(offsetY > 0)
						canvas.SelectedArea.setBounds(clickPoint.x, clickPoint.y, Math.abs(offsetX), Math.abs(offsetY));
					else
						canvas.SelectedArea.setBounds(clickPoint.x, e.getY(), Math.abs(offsetX), Math.abs(offsetY));
				else
					if(offsetY > 0)
						canvas.SelectedArea.setBounds(e.getX(), clickPoint.y, Math.abs(offsetX), Math.abs(offsetY));
					else
						canvas.SelectedArea.setBounds(e.getX(), e.getY(), Math.abs(offsetX), Math.abs(offsetY));
				canvas.SelectedArea.setSize(Math.abs(e.getX() - clickPoint.x), Math.abs(e.getY() - clickPoint.y));
			}
			
		}
		else {
			canvas.SelectedArea.setSize(Math.abs(e.getX() - clickPoint.x), Math.abs(e.getY() - clickPoint.y));
		}
		
		if(this.canvas.getshapesInGroup().size() == 1){
			Shape tmp = this.canvas.getshapesInGroup().get(0);
			if(tmp instanceof Line != true){
				this.canvas.setSelectedObj(tmp);
			}
		}
		
		this.canvas.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		this.clickPoint = null;
		this.shape = null;
		this.canvas.SelectedArea.setBounds(0, 0, 0, 0);
		this.canvas.repaint();
	
		
	}



}
