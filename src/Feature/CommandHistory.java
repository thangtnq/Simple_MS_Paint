package Feature;
import java.util.Stack;

import Interfaces.IUndoable;

class CommandHistory {
	private static final Stack<IUndoable> undo = new Stack<IUndoable>();
	private static final Stack<IUndoable> redo = new Stack<IUndoable>();

	public static void add(IUndoable cmd) {
		undo.push(cmd);
		redo.clear();
	}
	
	public static boolean undo() {
		if (!undo.empty()) {
			IUndoable c = undo.pop();
			redo.push(c);
			c.undo();
			return false;
		}
		
		return true;
	}

	public static boolean redo() {
		if (!redo.empty()) {
			IUndoable c = redo.pop();
			undo.push(c);
			c.redo();
			return false;
		}
		return true;
	}
}
