package validators;

import java.awt.Point;

import org.w3c.dom.events.EventException;

import enums.TypeOfBox;
import model.Board;

public class ValidatorBoard implements IValidator {
	private Board board;

	public ValidatorBoard(Board board) {
		this.board = board;
	}

	public boolean isValidPositionForBox(Point position) {
		try {
			this.board.getBox(position);
		} catch (EventException e) {
			return false;
		}
		return true;
	}

	public boolean isValidPositionForObjectGraphic(Point position) {
		if (this.board.getBox(position).getTypeOfBox().equals(TypeOfBox.NO_WALK)) {
			System.out.println("yes");
			return false;
		}
		return true;
	}
}
