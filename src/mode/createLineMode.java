package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import shape.Shape;
import shape.BasicObj;
import shape.Line;
import shape.AssociationLine;
import shape.CompositionLine;
import shape.GeneralizationLine;

public class createLineMode extends Mode {
	private String lineType;
	private Point clickPoint = null;
	private List<Shape> shapes = new ArrayList<Shape>();;
	private Shape shape = null;
	private BasicObj startObj = null;
	private BasicObj endObj = null;
	private Point startP = null;
	private Point endP = null;
	private Line line = null;
	private Factory factory = new ShapeFactory();
	
	public createLineMode(String type) {
		lineType = type;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		shapes = canvas.getShapeList();
		clickPoint = e.getPoint();
		
		for(int i = shapes.size()-1; i >= 0; i--) {
			shape = shapes.get(i);
			if(shape instanceof BasicObj && shape.IsInside(clickPoint)) {
				startObj = (BasicObj) shape;
				startP = startObj.getPort(clickPoint);
				break;
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(startP != null) {
			line = factory.createLine(lineType, startP, e.getPoint());
			this.canvas.setLine(line);
			canvas.repaint();
		}
		

	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		for (int i = this.shapes.size()-1; i >= 0; i--)
		{	
			Shape shape = shapes.get(i);
			if(shape == this.startObj){
				continue;
			}
			if(shape.IsInside(e.getPoint())){
				this.endObj = (BasicObj) shape;
				this.endP = this.endObj.getPort(e.getPoint());
				this.canvas.getLine().currentPoint(endP);
				this.canvas.getLine().setConnectedObj(this.startObj, this.endObj);
				this.canvas.addShape(this.canvas.getLine());
				this.startObj.addLine(this.canvas.getLine());
				this.endObj.addLine(this.canvas.getLine());
				break;
			}
		}
		this.clickPoint = null;
		this.startP = null;
		this.canvas.reset();
		this.canvas.repaint();

	}

//	public Line createLine(String type, Point startP, Point endP) {
//		if(type.equals("association")){
//			return new AssociationLine(startP, endP);
//		}
//		else if(type.equals("generalization")){
//			return new GeneralizationLine(startP, endP);
//		}
//		else if(type.equals("composition")) {
//			return new CompositionLine(startP, endP);
//		}
//		return null;
//	}

}
