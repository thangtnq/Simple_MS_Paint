package MouseHandler;

import java.util.ArrayList;

import Feature.Move;
import Interfaces.ICommand;
import Interfaces.IShape;
import model.ShapeList;

public class Move_MouseDrag implements ICommand {
	private MouseHandler mouse;
	private ICommand command;
	
	
	public Move_MouseDrag(MouseHandler m, ICommand c) {
		mouse = m;
		command = c;
	}
	
	@Override
	public void run() {
		ArrayList<IShape> selectedShapes = ShapeList.getInstance().getSelectedShapes();
		Move move = (Move)command;

		move.setDeltaX(mouse.getEndingX() - mouse.getStartingX());
		move.setDeltaY(mouse.getEndingY() - mouse.getStartingY());
		
		for (IShape shape : selectedShapes) {
			shape.setMinX(move.getOriginXMap().get(shape) + mouse.getEndingX() - mouse.getStartingX());
			shape.setMinY(move.getOriginYMap().get(shape) + mouse.getEndingY() - mouse.getStartingY());
		}
	}

}
