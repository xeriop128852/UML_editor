package shape;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public class UseCase extends BasicObj {

	public UseCase(Point p) {
		this.location = p;
		this.height = 90;
		this.width = 120;
		generatePorts();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(location.x, location.y, width, height);
		
		int stringWidth = g.getFontMetrics(font).stringWidth(objectName);
		g.setFont(font);	
		g.drawString(objectName, location.x + (width - stringWidth)/2, location.y + width/2 - 10);
		
		if(IsSelected())
			drawPorts(g);
	}

}
