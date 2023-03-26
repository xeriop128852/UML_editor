package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Currency;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.*;

import javax.swing.JPanel;

import shape.Shape;
import shape.UseCase;
import shape.Class;

public class Canvas extends JPanel {
	private static Canvas instance = null;
	
	
	public Canvas() {
	}
	
	public static Canvas getInstance() {
		if (instance == null) {
			instance = new Canvas();
		}
		return instance;
	}

	public void addShape(Shape shape) {
		
	}
	public void paint(Graphics g) {
		/* set canvas area */
		Dimension dim = getSize();
		g.setColor(new Color(35, 37, 37));
		g.fillRect(0, 0, dim.width, dim.height);
		/* set painting color */
		g.setColor(Color.white);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1));
		
		Point p = new Point(100, 100);
		UseCase x = new UseCase(p);
		x.draw(g2);
		
		Point p2 = new Point(500,500);
		Class c = new Class(p2);
		c.draw(g2);

	}
	
}
