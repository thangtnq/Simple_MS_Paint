package Feature;

import java.util.ArrayList;

import Interfaces.ICommand;
import Interfaces.IShape;
import Interfaces.IUndoable;
import MouseHandler.MouseHandler;
import model.ShapeColor;
import model.ShapeFactory;
import model.ShapeList;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;

public class CreateShape implements ICommand, IUndoable {
	private static IApplicationState app;
	private static MouseHandler mouse;
	private static ShapeList shapeList;
	private IShape shape;
	
	public CreateShape(MouseHandler m, IApplicationState a) {
		app = a;
		mouse = m;
		shapeList = ShapeList.getInstance();
	}
	
	@Override
	public void undo() {
		shapeList.removeShape(shape);
		shapeList.updateShapes();
	}

	@Override
	public void redo() {
		shapeList.addShape(shape);
		shapeList.updateShapes();
	}

	@Override
	public void run() {
		ShapeColor primaryColor = app.getActivePrimaryColor();
		ShapeColor secondaryColor = app.getActiveSecondaryColor(); 
		
		if (mouse.getReverse()) {
			primaryColor = app.getActiveSecondaryColor(); 
			secondaryColor = app.getActivePrimaryColor();
		} 
				 
		ShapeShadingType shade = app.getActiveShapeShadingType();

		switch(app.getActiveShapeType()) {
		case ELLIPSE:
			shape = ShapeFactory.createEllipse(primaryColor, secondaryColor, shade, mouse.getMinX(), mouse.getMinY(), mouse.getWidth(), mouse.getHeight());
			break;
		case RECTANGLE:
			shape = ShapeFactory.createRectangle(primaryColor, secondaryColor, shade,mouse.getMinX(), mouse.getMinY(), mouse.getWidth(), mouse.getHeight());
			break;
		case TRIANGLE:
			shape = ShapeFactory.createTriangle(primaryColor, secondaryColor, shade, mouse.getMinX(), mouse.getMinY(), mouse.getWidth(), mouse.getHeight());
			break;
		}

		shapeList.addShape(shape);
		ArrayList<IShape> newList = new ArrayList<IShape>();
		newList.add(shape);
		shapeList.setSelectedShapes(newList);
		shapeList.updateShapes();
		CommandHistory.add(this);
	}
}
