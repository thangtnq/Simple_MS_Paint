package MouseHandler;

import java.util.ArrayList;

import Interfaces.ICommand;
import Interfaces.IShape;
import model.ShapeList;

public class Draw_MouseDrag implements ICommand {
	private MouseHandler mouse;

	public Draw_MouseDrag(MouseHandler m) {
		mouse = m;
	}

	@Override
	public void run() {
		ArrayList<IShape> selectedShapes = ShapeList.getInstance().getSelectedShapes();
		
		for (IShape shape : selectedShapes) {
			shape.set_X_Y_Width_Height(mouse.getMinX(), mouse.getMinY(), mouse.getWidth(), mouse.getHeight());
		}
	}

}
