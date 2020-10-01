package Feature;

import java.util.ArrayList;

import Interfaces.ICommand;
import Interfaces.IShape;
import Interfaces.IUndoable;
import model.ShapeColor;
import model.ShapeFactory;
import model.ShapeList;
import model.ShapeShadingType;

public class Paste implements ICommand, IUndoable {
	private static ShapeList shapeList;
	private ArrayList<IShape> oldShapes;
	private ArrayList<IShape> newShapes;
	private final int newPosition = 100;
	
	public Paste() {
		shapeList = ShapeList.getInstance();
		newShapes = new ArrayList<IShape>();
	}

	@Override
	public void undo() {
		for (IShape shape : newShapes) {
			shapeList.removeShape(shape);
		}
		shapeList.updateShapes();
	}

	@Override
	public void redo() {
		for (IShape shape : newShapes) {
			shapeList.addShape(shape);
		}
		shapeList.updateShapes();
	}

	@Override
	public void run() {
		oldShapes = shapeList.getCopiedShapes();
		
		for (IShape shape : oldShapes) {
			IShape copiedShape = createCopyShape(shape);
			newShapes.add(copiedShape);
			shapeList.addShape(copiedShape);
		}
		shapeList.setSelectedShapes(newShapes);
		shapeList.setCopiedShapes(newShapes);
		shapeList.updateShapes();
		CommandHistory.add(this);
	}
	
	public IShape createCopyShape(IShape shape) {
		int minX = shape.getMinX() + newPosition;
		int minY = shape.getMinY() + newPosition;
		int width = shape.getWidth();
		int height = shape.getHeight();
		ShapeColor primaryColor = shape.getPrimaryColor();
		ShapeColor secondaryColor = shape.getSecondaryColor(); 
		ShapeShadingType shade = shape.getShade();
		IShape copiedShape = null;

		switch(shape.getShapeType()) {
		case ELLIPSE:
			copiedShape = ShapeFactory.createEllipse(primaryColor, secondaryColor, shade, minX, minY, width, height);
			break;
		case RECTANGLE:
			copiedShape = ShapeFactory.createRectangle(primaryColor, secondaryColor, shade, minX, minY, width, height);
			break;
		case TRIANGLE:
			copiedShape = ShapeFactory.createTriangle(primaryColor, secondaryColor, shade, minX, minY, width, height);
			break;
		}
		return copiedShape;
	}

}
