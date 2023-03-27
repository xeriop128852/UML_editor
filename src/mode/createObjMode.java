package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import shape.BasicObj;
import shape.UseCase;
import view.Canvas;
import shape.Class;

public class createObjMode extends Mode {
	private String objType = null;
	
	public createObjMode(String type) {
		this.objType = type;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(objType.equals("class")) {
			canvas.addShape(new Class(e.getPoint()));
		}else if(objType.equals("usecase"))  {
			canvas.addShape(new UseCase(e.getPoint()));
		}
		canvas.repaint();
	}

}
