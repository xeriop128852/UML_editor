package mode;

import java.awt.event.MouseEvent;

import shape.UseCase;
import shape.BasicObj;
import shape.Class;

public class createObjMode extends Mode {
	private String objType = null;
	private Factory factory = new ShapeFactory();
	
	public createObjMode(String type) {
		this.objType = type;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		BasicObj obj = factory.createBasicObj(objType, e.getPoint());
		canvas.addShape(obj);
		canvas.repaint();
	}

}
