package executors;

import java.awt.Point;

import enums.Orientation;
import model.Avatar;
import model.Map;

public class CommandMove implements ICommand {

	public CommandMove() {
	}

	public void executeCommand(Map map) {
		moveAvatar(map, (Avatar) map.getBox(map.getAvatarPos()).getObjectGraphic());
	}
///los movimientos de todos los avatares
	public void moveAvatar(Map map, Avatar avatar) {
		if (avatar.getOrientation() == Orientation.RIGHT) {
			if (!map.isOcupatePosition(new Point(map.getAvatarPos().x + 1, map.getAvatarPos().y))) {
				map.addBoxObjectGraphic(new Point(map.getAvatarPos().x + 1, map.getAvatarPos().y), avatar);
				map.getBoard().setAvatarPos(new Point(map.getBoard().getAvatarPos().x - 1, map.getBoard().getAvatarPos().y));
				map.deleteObjectGraphic(map.getAvatarPos());
			}
		}
	}

}
