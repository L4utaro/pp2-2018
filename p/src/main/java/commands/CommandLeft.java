package commands;

import model.Map;
import enums.Orientation;
import model.Avatar;

public class CommandLeft implements ICommand {

	public void executeCommand(Map map) {
		makeChangeOfOrientation((Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic());
	}

	public void makeChangeOfOrientation(Avatar avatar) {
		avatar.turnLeft();
	}
}
