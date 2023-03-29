package shape;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public class Class extends BasicObj {
	
	public Class(Point p) {
		this.startP = p;
		this.height = 120;
		this.width = 90;
		this.endP = setEndLocation(startP, height, width);
		generatePorts();
	}

	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(startP.x, startP.y, width, height);
		int portion = height / 3;
		g.drawLine(startP.x, startP.y + portion, startP.x + width, startP.y + portion);
		g.drawLine(startP.x, startP.y + portion * 2, startP.x + width, startP.y + portion * 2);
		
		int stringWidth = g.getFontMetrics(font).stringWidth(objectName);
		g.setFont(font);	
		g.drawString(objectName, startP.x + (width - stringWidth)/2 , startP.y + portion/2 + 5);
		
		if(IsSelected())
			drawPorts(g);
	}

}
