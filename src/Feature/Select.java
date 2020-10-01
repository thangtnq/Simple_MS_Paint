package Feature;

import java.util.ArrayList;

import Interfaces.ICommand;
import Interfaces.IShape;
import MouseHandler.MouseHandler;
import model.ShapeColor;
import model.ShapeFactory;
import model.ShapeList;
import model.ShapeShadingType;

public class Select implements ICommand {
	private static MouseHandler mouse;
	private static ShapeList shapeList;
	
	public Select(MouseHandler m) {
		mouse = m;
		shapeList = ShapeList.getInstance();
	}

	@Override
	public void run() {
		IShape shape = ShapeFactory.createRectangle(ShapeColor.WHITE, ShapeColor.WHITE, ShapeShadingType.OUTLINE, mouse.getMinX(), mouse.getMinY(), mouse.getWidth(), mouse.getHeight());
		ArrayList<IShape> list = new ArrayList<IShape>();
		list.add(shape);
		shapeList.setSelectedShapes(list);
	}
}
