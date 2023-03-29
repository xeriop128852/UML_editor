package shape;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public class Class extends BasicObj {
	
	public Class(Point p) {
		this.location = p;
		this.height = 120;
		this.width = 90;
		generatePorts();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(location.x, location.y, width, height);
		int portion = height / 3;
		g.drawLine(location.x, location.y + portion, location.x + width, location.y + portion);
		g.drawLine(location.x, location.y + portion * 2, location.x + width, location.y + portion * 2);
		
		int stringWidth = g.getFontMetrics(font).stringWidth(objectName);
		g.setFont(font);	
		g.drawString(objectName, location.x + (width - stringWidth)/2 , location.y + portion/2 + 5);
		
		if(IsSelected())
			drawPorts(g);
	}

}
