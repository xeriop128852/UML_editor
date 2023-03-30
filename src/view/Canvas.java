package view;

import java.util.ArrayList;
import java.util.List;
import java.util.EventListener;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import shape.Shape;
import shape.BasicObj;
import shape.Line;
import mode.*;
import shape.Group;

public class Canvas extends JPanel {
	private static Canvas instance = null;
	
	private EventListener listener = null;
	protected Mode currentMode = null;
	
	private List<Shape> shapes = new ArrayList<Shape>();
	public Shape selectedObj = null;
	public Line line = null;
	public Group group;
	
	public Rectangle SelectedArea = new Rectangle(0,0,0,0);
	
	public Canvas() {
	}
	
	public static Canvas getInstance() {
		if (instance == null) {
			instance = new Canvas();
		}
		return instance;
	}

	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public List<Shape> getShapeList() {
		return this.shapes;
	}
	
	public void setCurrentMode(Mode mode) {
		this.currentMode = mode;
	}
	
	public void resetCurrentMode() {
		removeMouseListener((MouseListener) listener);
		removeMouseMotionListener((MouseMotionListener) listener);
		this.listener  = this.currentMode;
		addMouseListener((MouseListener) listener);
		addMouseMotionListener((MouseMotionListener) listener);
	}
	
	public void setSelectedObj(Shape shape) {
		this.selectedObj = shape;
		selectedObj.setSelected(true);
	}
	
	public Shape getSelectedObj() {
		return this.selectedObj;
	}
	
	public void setLine(Line line) {
		this.line = line;
	}

	public Line getLine() {
		return this.line;
	}
	
	public List<Shape> getshapesInGroup() {
		List<Shape> selectshapes = new ArrayList<Shape>();
		List<Line> selectlines = new ArrayList<Line>();
		for (int i = 0; i < this.shapes.size(); i++) {
			Shape shape = this.shapes.get(i);
			if (shape.IsSelected()){
				if (shape instanceof Line) {
					selectlines.add((Line)shape);
				}
				else{
					selectshapes.add(shape);
				}
			}
		}
		return selectshapes;
	}
	
	public void changeObjName(String name) {
		if((selectedObj instanceof BasicObj) && (selectedObj!=null)) {
			BasicObj shape = (BasicObj)selectedObj;
			shape.changeName(name);
			repaint();
		}
	}
	
//	public void Group() {
//		Group group = new Group();
//		for (int i = 0; i < shapes.size(); i++) {
//			Shape shape = shapes.get(i);
//			if (shape.group_selected) {
//				group.addShapes(shape);
//				shapes.remove(i);
//				i--;
//			}
//		}
//		group.setBounds();
//		shapes.add(group);
//	}
	
	public void Group(List<Shape> shapeList) {
		group = new Group(shapeList);
		shapes.add(group);
		for (int i = 0; i < shapeList.size(); i++) {
			shapeList.get(i).setGroup(true);
			//group.addShape(shapeList.get(i));
			this.shapes.remove(shapeList.get(i));
			
		}
	}
	
	public void UnGroup(Shape shape) {
		List<Shape> shapelist = ((Group) shape).getShapes();
		for (int i = 0; i < shapelist.size(); i++) {
			shapelist.get(i).setGroup(false);
			this.shapes.add(shapelist.get(i));
		}
		this.shapes.remove(shape);
		
	}
	
	public void reset() {
		this.line = null;
		if(selectedObj != null){
			//selectedObj.resetShapesInGroup();   //reset group
			selectedObj = null;
		}
		for (int i = shapes.size() - 1; i >= 0; i--) {
			shapes.get(i).setSelected(false);
		}
		//SelectedArea.setBounds(0, 0, 0, 0); 
	}


	public boolean checkSelectedArea(Shape shape) {
		if (SelectedArea.contains(shape.getStartLocation())
				&& SelectedArea.contains(shape.getEndLocation())) {
			return true;
		}
		return false;
	}
	
	public void paint(Graphics g) {
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0, 0, dim.width, dim.height);
		
		g.setColor(new Color(35, 37, 37));
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1));
		
		for(int i = 0; i < shapes.size(); i++) {
			Shape shape = shapes.get(i);
			shape.draw(g);
			
			// draw ports when object is selected
			if (shape.IsSelected() && (shape instanceof BasicObj)) {
				BasicObj basic = (BasicObj) shape;
				basic.drawPorts(g);
			}else if(selectedObj != null) {
				selectedObj.drawPorts(g);
			}
			
			
//			
//			if (shape.IsSelected() && (shape instanceof Group)) {
//				Group group = (Group) shape;
//				group.draw(g);
//			}
			
			shape.setGroup(false);
			if (!SelectedArea.isEmpty()  && checkSelectedArea(shape)) {
				shape.drawPorts(g);
				shape.setSelected(true);
				shape.setGroup(true);
			}
			
			
		}
		
		if (line != null) {
			this.line.draw(g);
		}


		
		if (!SelectedArea.isEmpty()) {
			int alpha = 15;
			g.setColor(new Color(37, 148, 216, alpha));
			g.fillRect(SelectedArea.x, SelectedArea.y, SelectedArea.width, SelectedArea.height);
			g.setColor(new Color(37, 148, 216));
			g.drawRect(SelectedArea.x, SelectedArea.y, SelectedArea.width, SelectedArea.height);

		}
	}

	
	
}
