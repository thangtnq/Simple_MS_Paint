package Feature;

import java.util.ArrayList;

import Interfaces.ICommand;
import Interfaces.IShape;
import Interfaces.IUndoable;
import model.ShapeList;

public class DeleteShape implements ICommand, IUndoable {
	private static ShapeList shapeList;
	private ArrayList<IShape> deletedShapes;
	
	public DeleteShape() {
		shapeList = ShapeList.getInstance();
	}

	@Override
	public void undo() {
		for (IShape shape : deletedShapes) {
			shapeList.addShape(shape);
		}
		shapeList.updateShapes();
	}

	@Override
	public void redo() {
		for (IShape shape : deletedShapes) {
			shapeList.removeShape(shape);
		}
		shapeList.updateShapes();
	}

	@Override
	public void run() {
		deletedShapes = shapeList.getSelectedShapes();
		
		for (IShape shape : deletedShapes) {
			shapeList.removeShape(shape);
		}
		
		shapeList.updateShapes();
		CommandHistory.add(this);
	}


}
