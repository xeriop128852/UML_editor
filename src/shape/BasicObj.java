package shape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;


public abstract class BasicObj extends Shape {
	protected int width, height;
	private int portNum = 4;
	protected Point[] ports = new Point[portNum];
	protected String objectName = "default";
	protected Font font = new Font(Font.DIALOG, Font.BOLD, 14);
	
	public BasicObj() {
		width = height = 0;
		startP = new Point();
		ports = new Point[portNum];
		for(int i = 0; i < portNum ; i++)
			ports[i] = new Point();
		
		endP = setEndLocation(startP, width, height);
	}

	public abstract void draw(Graphics g);
	
	
	public void changeName(String name){
		objectName = name;
	}

	public void generatePorts() {
		int xmiddle = (startP.x + startP.x + width)/2;
		int ymiddle = (startP.y + startP.y + height)/2;
		ports[0].setLocation(startP.x, ymiddle);
		ports[1].setLocation(xmiddle, startP.y);
		ports[2].setLocation(xmiddle, startP.y + height);
		ports[3].setLocation(startP.x + width, ymiddle);
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
	
	//判斷滑鼠所點的地方有沒有點到物件上
	public boolean IsInside(Point p){
		return ((p.getX() > startP.x) && 
				(p.getX() < startP.x + width) &&
				(p.getY() > startP.y) &&
				(p.getY() < startP.y + height) );
	}
	
	public void move(int offsetX, int offsetY){
		startP.x += offsetX;
		startP.y += offsetY;
		endP = setEndLocation(startP, width, height);
		resetPorts(offsetX, offsetY);
	}
	
	public void resetPorts(int offsetX, int offsetY){
		for(int i = 0; i < portNum; i++) {
			ports[i].setLocation(ports[i].x + offsetX, ports[i].y + offsetY);
		}
	}
	
}