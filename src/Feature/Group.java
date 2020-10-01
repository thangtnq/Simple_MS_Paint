package Feature;

import java.util.ArrayList;

import Interfaces.ICommand;
import Interfaces.IShape;
import MouseHandler.MouseHandler;
import model.ShapeColor;
import model.ShapeFactory;
import model.ShapeList;
import model.ShapeShadingType;

public class Group implements ICommand{
	private static MouseHandler mouse;
	private static ShapeList shapeList;
	
	public Group(MouseHandler m) {
		mouse = m;
		shapeList = ShapeList.getInstance();
	}
	@Override
	public void run() {
		
	}
	
	
}
