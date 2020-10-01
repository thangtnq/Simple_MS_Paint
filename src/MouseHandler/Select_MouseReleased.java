package MouseHandler;

import Interfaces.ICommand;
import model.ShapeList;

public class Select_MouseReleased implements ICommand {
	private ShapeList shapeList;
	private MouseHandler mouse;
	
	public Select_MouseReleased(MouseHandler m) {
		mouse = m;
		shapeList = ShapeList.getInstance();
	}

	@Override
	public void run() {
		shapeList.selectShapes(mouse.getMinX(),  mouse.getMinX() + mouse.getWidth(), mouse.getMinY(), mouse.getMinY() + mouse.getHeight());
	}
}
