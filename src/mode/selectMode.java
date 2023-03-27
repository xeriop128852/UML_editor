package mode;

import java.awt.event.MouseEvent;
import java.awt.Point;
import java.util.List;

import view.Canvas;
import shape.Shape;

public class selectMode extends Mode {
	protected Canvas canvas;
	private Point clickPoint = null;
	private List<Shape> shapes;
	private Shape shape = null;
	
	public selectMode() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		canvas.reset();
		clickPoint = e.getPoint();
		shapes = canvas.getShapeList();
		
		for(int i = 0; i < shapes.size(); i++) {
			Shape shape = shapes.get(i);
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
