package mode;

import java.awt.Point;

import shape.BasicObj;
import shape.UseCase;
import shape.Class;


public class ShapeFactory implements ShapeFactoryInterface{
	public BasicObj createObj(String objType, Point p) {
		if(objType.equals("class")){
			
			return new Class(p);
		}
		else if(objType.equals("usecase")){
			return new UseCase(p);
		}
		return null;
	}

	
}