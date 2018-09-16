package model;

import java.awt.Point;

public class Avatar implements IObjectGraphic{
	private Point position;
	
	public Avatar() {
		
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
}
