package shape;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public class UseCase extends BasicObj {

	public UseCase(Point p) {
		this.startP = p;
		this.height = 90;
		this.width = 120;
		this.endP = setEndLocation(startP, width, height);
		generatePorts();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(startP.x, startP.y, width, height);
		
		int stringWidth = g.getFontMetrics(font).stringWidth(objectName);
		g.setFont(font);	
		g.drawString(objectName, startP.x + (width - stringWidth)/2, startP.y + width/2 - 10);
		
		if(IsSelected())
			drawPorts(g);
	}

}
