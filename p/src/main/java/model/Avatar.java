package model;

import enums.Orientation;

public class Avatar implements IObjectGraphic{
	private Orientation orientation;
	private Integer numOfOrientation2;
	public Avatar() {
		this.orientation = Orientation.RIGHT;
		this.numOfOrientation2 = 90;
	}

	public void turnLeft() {
		this.numOfOrientation2 -=90;
	}

	public void turnRight() {
		this.numOfOrientation2 +=90;
	}
	
	public void move() {
		
	}
	
	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
}
