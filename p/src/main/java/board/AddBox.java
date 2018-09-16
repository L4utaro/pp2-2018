package board;

import java.awt.Point;
import java.util.List;

import enums.TypeOfBox;
import model.Board;
import model.IObjectGraphic;
import model.Light;
import validators.ValidatorBoard;

public class AddBox {
	private Board board;
	private ValidatorBoard validatorBoard;

	public AddBox(Board board) {
		this.board = board;
		this.validatorBoard = new ValidatorBoard(this.board);
		autoCompleteBoxesEmpty();
	}

	public void addboxes(List<Point> posOfPathPossible) {
		for (Point position : posOfPathPossible) {
			if (!this.validatorBoard.isValidPositionForBox(position)) {
				throw new IllegalArgumentException("It is not a valid box to add an ObjectGraphic");
			}
			addBoxWalk(position);
		}
	}

	public void autoCompleteBoxesEmpty() {
		for (int y = 1; y <= this.board.getBoxes()[0].length; y++) {
			for (int x = 1; x <= this.board.getBoxes().length; x++) {
				addBoxNoWalk(new Point(x, y));
			}
		}
	}

	public void addObjectGraphic(Point position, IObjectGraphic objectGraphic) {
		if (!this.validatorBoard.isValidPositionForBox(position)
				|| !this.validatorBoard.isValidPositionForObjectGraphic(position)) {
			throw new IllegalArgumentException("It is not a valid box to add an ObjectGraphic");
		}
		this.board.addBox(position, TypeOfBox.WALK, objectGraphic);
	}

	public void addBoxWalk(Point position) {
		this.board.addBox(position, TypeOfBox.WALK, null);
	}

	public void addBoxNoWalk(Point position) {
		this.board.addBox(position, TypeOfBox.NO_WALK, null);
	}

	public void addLights(List<Point> posOfLights, Light light) {
		for (Point position : posOfLights) {
			if (!this.validatorBoard.isValidPositionForBox(position)) {
				throw new IllegalArgumentException("It is not a valid box to add an ObjectGraphic");
			}
			addObjectGraphic(position, light);
		}
	}
	
	public boolean validatePositions(List<Point> positionsOfStructure) {
		for (Point pos : positionsOfStructure) {
			if (this.board.isOcupatePosition(pos)) {
				return false;
			}
		}
		return true;
	}
}