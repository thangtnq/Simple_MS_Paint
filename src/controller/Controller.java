package controller;

import Feature.*;
import Interfaces.ICommand;
import MouseHandler.Draw_MouseDrag;
import MouseHandler.Draw_MouseReleased;
import MouseHandler.MouseHandler;
import MouseHandler.Move_MouseDrag;
import MouseHandler.Move_MouseReleased;
import MouseHandler.Select_MouseDrag;
import MouseHandler.Select_MouseReleased;
import model.ShapeList;
import model.StartAndEndPointMode;
import model.interfaces.*;


public class Controller {
	private static MouseHandler mouse;
	private static IApplicationState appState;
	private static ShapeList shapeList;
	private static ICommand command = null;

	public static void setup(MouseHandler m, IApplicationState a) {
		mouse = m;
		appState = a;
		shapeList = ShapeList.getInstance();
	}
	
	public static void mousePressed() {
		if(appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.DRAW)) {
			command = new CreateShape(mouse, appState);
		}
		else if (appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.SELECT)) {
			command = new Select(mouse);
		}
		else if(appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.MOVE)) {
			command  = new Move(mouse);
		}
		
		command.run();
	}
	
	public static void mouseDragged() {
		ICommand strategy = null;
		
		if(appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.DRAW)) {
			strategy = new Draw_MouseDrag(mouse);
		}
		else if (appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.SELECT)) {
			strategy = new Select_MouseDrag(mouse);
		}
		else if(appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.MOVE)) {
			strategy = new Move_MouseDrag(mouse, command);
		}
		strategy.run();
		shapeList.updateShapes();
	}
	
	public static void mouseReleased() {
		ICommand strategy = null;
		
		if(appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.DRAW)) {
			strategy = new Draw_MouseReleased();
		}
		else if (appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.SELECT)) {
			strategy = new Select_MouseReleased(mouse);
		}
		else if(appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.MOVE)) {
			strategy = new Move_MouseReleased();
		}
		
		strategy.run();
		shapeList.updateShapes();
	}
	
	public static void copyShape() {
		command = new Copy();
		command.run();
	}
	
	public static void pasteShape() {
		command = new Paste();
		command.run();
	}
	
	public static void deleteShape() {
		command = new DeleteShape();
		command.run();
	}
	
	public static void undo() {
		command = new Undo();
		command.run();
	}
	
	public static void redo() {
		command = new Redo();
		command.run();
	}
	
	public static void group() {
		command = new Group(mouse);
		command.run();
	}
	
	public static void ungroup() {
		command = new Ungroup();
		command.run();
	}
}
