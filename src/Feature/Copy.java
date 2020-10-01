package Feature;

import java.util.ArrayList;

import Interfaces.ICommand;
import Interfaces.IShape;
import model.ShapeList;

public class Copy implements ICommand {
	private static ShapeList shapeList;
	private ArrayList<IShape> copiedShapes;
	
	public Copy() {
		shapeList = ShapeList.getInstance();
	}

	@Override
	public void run() {
		copiedShapes = shapeList.getSelectedShapes();
		shapeList.setCopiedShapes(copiedShapes);
	}
}