package model;

import java.awt.Point;

import enums.TypeOfBox;

public class Board {
	private Box[][] boxes;

	public Board(Point sizeBoard) {
		boxes = new Box[sizeBoard.x][sizeBoard.y];
	}

	public Box[][] getBoxes() {
		return boxes;
	}

	public boolean isOcupatePosition(Point box) {
		if ((boxes.length <= box.x) || (0 > box.x) || (boxes[0].length <= box.y) || (0 > box.y)) {
			throw new IllegalArgumentException("No se puede acceder a la casilla, excede el limite del mapa");
		}
		return boxes[box.x][box.y] != null;
	}

	public Box getBox(Point pointBox) {
		return boxes[pointBox.x - 1][pointBox.y - 1];
	}

	public void deleteBox(Point pointBox) {
		boxes[pointBox.x - 1][pointBox.y - 1] = null;
	}

	public void addBox(Point pointBox, TypeOfBox typeOfBox, IObjectGraphic objectGraphic) {
		boxes[pointBox.x - 1][pointBox.y - 1] = new Box(typeOfBox, objectGraphic);
	}

	public void printBoard() {
		String file = "";
		for (int y = 0; y < boxes[0].length; y++) {
			for (int x = 0; x < boxes.length; x++) {
				if (boxes[x][y] != null) {
					if (boxes[x][y].getTypeOfBox().equals(TypeOfBox.NO_WALK)) {
						file = file + "[ NO_WALK]";
						//aca tengo problema porque getObject == Null,
					} else if (!(boxes[x][y].getObjectGraphic()).equals(null)) {
						file = file + "[" +boxes[x][y].getObjectGraphic().getClass().getName() + "]";
					} else {
						file = file + "[ WALK]";
					}
				} else {
					file = file + "[ null]";
				}
			}
			System.out.println(file);
			file = "";
		}
	}

	public Point getLimitsBoard() {
		return new Point(boxes.length, boxes[0].length);
	}

	public Integer size() {
		return getBoxes().length;
	}

	public Integer getColumnsSize() {
		return getBoxes()[0].length;
	}
}