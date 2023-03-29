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
import shape.Class; 
import shape.UseCase;
import shape.Shape;
import mode.*;
import shape.AssociationLine;
import shape.GeneralizationLine;
import shape.CompositionLine;

public class Canvas extends JPanel {
	private static Canvas instance = null;
	
	private EventListener listener = null;
	protected Mode currentMode = null;
	
	private List<Shape> shapes = new ArrayList<Shape>();
	private Shape selectedObj = null;
	public Line line = null;
	
	public Rectangle SelectedArea = new Rectangle();
	
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
	
	public void changeObjName(String name) {
		if((selectedObj instanceof BasicObj) && (selectedObj!=null)) {
			BasicObj shape = (BasicObj)selectedObj;
			shape.changeName(name);
			repaint();
		}
	}
	
	public void reset() {
		this.line = null;
		if(selectedObj != null){
			//selectedObj.resetSelectedShape();   //reset group
			selectedObj = null;
		}
//		for (int i = shapes.size() - 1; i >= 0; i--) {
//			shapes.get(i).setSelected(false);
//		}
		SelectedArea.setBounds(0, 0, 0, 0); ///Group
	}

	

	public boolean checkSelectedArea(Shape shape) {
		/* show ports of selected objects */
		if (SelectedArea.contains(shape.getStartLocation()) && SelectedArea.contains(shape.getEndLocation())) {
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
			
			// check select
			if (checkSelectedArea(shape)) {
				shape.setSelected(true);
			}

			// draw ports when object is selected
			if (shape.IsSelected() && (shape instanceof BasicObj)) {
				BasicObj basic = (BasicObj) shape;
				basic.drawPorts(g);
			}else if (selectedObj == shape) {
				BasicObj basic = (BasicObj) shape;
				basic.drawPorts(g);
			}
			
			if (!SelectedArea.isEmpty()  && checkSelectedArea(shape)) {
				shape.drawPorts(g);
				//shape.group_selected = true;
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
