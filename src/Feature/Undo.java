package Feature;

import Interfaces.ICommand;

public class Undo implements ICommand {
	@Override
	public void run() {
		CommandHistory.undo();
	}
}
