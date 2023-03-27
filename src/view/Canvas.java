package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Currency;
import java.util.EventListener;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import shape.Shape;
import shape.BasicObj;
import shape.Class; 
import shape.UseCase;
import shape.Shape;
import mode.*;

public class Canvas extends JPanel {
	private static Canvas instance = null;
	
	private EventListener listener = null;
	protected Mode currentMode = null;
	
	private List<Shape> shapes = new ArrayList<Shape>();
	private Shape selectedObj = null;
	
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
	
	
	
	public void changeObjName(String name) {
		if(selectedObj instanceof BasicObj) {
			BasicObj shape = (BasicObj)selectedObj;
			shape.changeName(name);
			repaint();
		}
	}
	
	public void reset() {
		if(selectedObj != null){
			//selectedObj.resetSelectedShape();   //reset group
			selectedObj = null;
		}
		//SelectedArea.setBounds(0, 0, 0, 0); ///Group
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
			
//			/* check group select */
//			if (checkSelectedArea(shape)) {
//				shape.setSelected(true);
//			}

			/* draw ports when object is selected */
			if (shape.IsSelected() && (shape instanceof BasicObj)) {
				BasicObj basic = (BasicObj) shape;
				basic.drawPorts(g);
			} 
//			else if (selectedObj == shape) {
//				shape.drawPorts(g);
//			}
		}

	}
	
}
