package shape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public abstract class BasicObj extends Shape {
	protected Point location;
	protected int width, height;
	private int portNum = 4;
	protected Point[] ports = new Point[4];
	protected String objectName = "default";
	protected Font font = new Font(Font.DIALOG, Font.BOLD, 14);
	private List<Line> lines = new ArrayList<Line>();
	
	public BasicObj() {
		location = new Point();
		ports = new Point[portNum];
		for(int i = 0; i < portNum ; i++)
			ports[i] = new Point();
	}

	public abstract void draw(Graphics g);

	public void changeName(String name){
		objectName = name;
	}

	public void generatePorts() {
		int xmiddle = (location.x + location.x + width)/2;
		int ymiddle = (location.y + location.y + height)/2;
		ports[0].setLocation(location.x, ymiddle);
		ports[1].setLocation(xmiddle, location.y);
		ports[2].setLocation(xmiddle, location.y + height);
		ports[3].setLocation(location.x + width, ymiddle);
	}
	
	public Point getPort(Point clickPoint) {
		double distance = 0;
		double min = 999;
		Point point = null;
		
		for(int i = 0; i < portNum; i++) {
			distance = Math.sqrt(Math.pow(clickPoint.x-ports[i].x, 2) + Math.pow(clickPoint.y-ports[i].y, 2));
			if(min > distance) {
				min = distance;
				point = ports[i];
			}
		}
		return point;
	}
	
	public void drawPorts(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		for(int i = 0; i < portNum ; i++) {
			g.fillRect(ports[i].x - 8, ports[i].y - 8 , 15, 15);
		}
	}
	
	public boolean IsInside(Point p){
		return ((p.getX() > location.x) && 
				(p.getX() < location.x + width) &&
				(p.getY() > location.y) &&
				(p.getY() < location.y + height) );
	}
	
	public void move(int offsetX, int offsetY){
		location.x += offsetX;
		location.y += offsetY;
		resetPorts(offsetX, offsetY);
	}
	
	public void resetPorts(int offsetX, int offsetY){
		for(int i = 0; i < portNum; i++) {
			ports[i].setLocation(ports[i].x + offsetX, ports[i].y + offsetY);
		}
	}
	
	public void addLine(Line line){
		this.lines.add(line);
	}
}