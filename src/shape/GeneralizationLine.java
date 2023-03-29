package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class GeneralizationLine extends Line {

	public GeneralizationLine(Point start, Point end) {
		super(start, end);
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(startP.x, startP.y, endP.x, endP.y);
		
		int dx = endP.x - startP.x;
		int dy = endP.y - startP.y;
		double d = Math.sqrt(dx*dx + dy*dy);
		double sin = dy/d;
		double cos = dx/d;
		
		double x1 = (d - 15)*cos - 15*sin + startP.x;
		double y1 = (d - 15)*sin + 15*cos + startP.y;

		double x2 = (d - 15)*cos - (-15)*sin + startP.x;
		double y2 = (d - 15)*sin + (-15)*cos + startP.y;

        int[] x = {endP.x, (int) x1, (int) x2};
        int[] y = {endP.y, (int) y1, (int) y2};

        g.fillPolygon(x, y, 3);
	}
}
