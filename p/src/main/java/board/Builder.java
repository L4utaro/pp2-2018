package board;

import java.awt.Point;
import java.util.List;

import model.Avatar;
import model.Board;
import model.Light;
import model.Map;

public class Builder {
	private Board board;
	private AddBox addBox;

	public Builder(Point sizeBoard) {
		if (sizeBoard == null) {
			throw new IllegalArgumentException("el tamanio no puede ser null");
		} else if (sizeBoard.x <= 1 || sizeBoard.y <= 1) {
			throw new IllegalArgumentException("el tamanio no puede ser menor a 1");
		}
		this.board = new Board(sizeBoard);
		this.addBox = new AddBox(this.board);
	}

	public Builder whitRoadPossible(List<Point> posOfPathPossible) {
		addRoadToMap(this.board, posOfPathPossible);
		return this;
	}

	public Builder whitAvatar(Point position) {
		addAvatarToMap(this.board, position);
		return this;
	}

	public Builder whitLights(List<Point> posOfLights) {
		addLightsToMap(posOfLights);
		return this;
	}

	public void addLightsToMap(List<Point> posOfLights) {
		this.addBox.addLights(posOfLights, new Light());
	}

	public void addAvatarToMap(Board board2, Point position) {
		this.addBox.addObjectGraphic(position, new Avatar());
	}

	public void addRoadToMap(Board board, List<Point> posOfPathPossible) {
		this.addBox.addboxes(posOfPathPossible);
	}

//	public Builder withStructureRectangle(Rectangle rectangle) {
//		addStructureByRectangle(board,rectangle);
//		return this;
//	}
//	
//	public Builder withStructureLine(Line line) {
//		addStructureByLine(board, line);
//		return this;
//	}
//	
//	public void addStructureByRectangle(Board board, Rectangle rectangle) {
//		AddStructure.addStructureByRectangle(board, rectangle);
//	}
//	
//	public void addStructureByLine(Board board, Line line) {
//		AddStructure.addStructureByLine(board, line);
//	}

	public Map build() {
		return new Map(this);
	}

	public Board getBoard() {
		return this.board;
	}
}