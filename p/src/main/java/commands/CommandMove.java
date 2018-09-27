package commands;

import java.awt.Point;

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
		if (avatar.getNumOfOrientation() == 0) {// up
			makeChangePositionOfAvatar(map, new Point(map.getAvatarPos().x, map.getAvatarPos().y + 1),
					map.getAvatarPos(), avatar);
		} else if (avatar.getNumOfOrientation() == 90) {// right
			makeChangePositionOfAvatar(map, new Point(map.getAvatarPos().x + 1, map.getAvatarPos().y),
					map.getAvatarPos(), avatar);
		} else if (avatar.getNumOfOrientation() == 180) {// down
			makeChangePositionOfAvatar(map, new Point(map.getAvatarPos().x, map.getAvatarPos().y + 1),
					map.getAvatarPos(), avatar);
		} else if (avatar.getNumOfOrientation() == 270) {// left
			makeChangePositionOfAvatar(map, new Point(map.getAvatarPos().x - 1, map.getAvatarPos().y),
					map.getAvatarPos(), avatar);
		}
	}

	public void makeChangePositionOfAvatar(Map map, Point oldPositionAvatar, Point newPositionAvatar, Avatar avatar) {
		if (!map.isOcupatePosition(newPositionAvatar)) {
			map.addBoxObjectGraphic(newPositionAvatar, avatar);
			map.getBoard().setAvatarPos(newPositionAvatar);
			map.deleteObjectGraphic(oldPositionAvatar);
		}
	}

}
