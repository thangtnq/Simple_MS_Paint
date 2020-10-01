package MouseHandler;

import Interfaces.ICommand;
import model.ShapeList;

public class Draw_MouseReleased implements ICommand {
	private ShapeList shapeList;

	public Draw_MouseReleased() {
		shapeList = ShapeList.getInstance();
	}

	@Override
	public void run() {
		shapeList.clearSelectedShapes();
	}
}
