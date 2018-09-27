package commands;

import enums.Orientation;
import model.Avatar;
import model.Map;

public class CommandRight implements ICommand {

	public void executeCommand(Map map) {
		makeChangeOfOrientation((Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic());
	}

	public void makeChangeOfOrientation(Avatar avatar) {
		avatar.turnRight();
		avatar.setOrientation(Orientation.RIGHT);
	}

}
