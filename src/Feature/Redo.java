package Feature;

import Interfaces.ICommand;

public class Redo implements ICommand {
	@Override
	public void run() {
		CommandHistory.redo();
	}
}
