package mode;

import java.awt.Point;

import shape.AssociationLine;
import shape.BasicObj;
import shape.Class;
import shape.CompositionLine;
import shape.GeneralizationLine;
import shape.Line;
import shape.UseCase;

public class ShapeFactory implements Factory {

	public ShapeFactory() {
	}

	@Override
	public BasicObj createBasicObj(String type, Point startP) {
		if(type.equals("class")) {
			return new Class(startP);
		}else if(type.equals("usecase"))  {
			return new UseCase(startP);
		}
		return null;
	}
	
	@Override
	public Line createLine(String type, Point startP, Point endP) {
		if(type.equals("association")){
			return new AssociationLine(startP, endP);
		}
		else if(type.equals("generalization")){
			return new GeneralizationLine(startP, endP);
		}
		else if(type.equals("composition")) {
			return new CompositionLine(startP, endP);
		}
		return null;
	}
}
