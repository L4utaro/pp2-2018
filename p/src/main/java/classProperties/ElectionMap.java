package classProperties;

import java.awt.Point;
import java.util.List;

public class ElectionMap {
	private Point mapSize;
	private Point posAvatar;
	private Point posLight;
	private List<Point> posOfPathPossible;
	
	public ElectionMap(Point mapSize, Point posAvatar, Point posLight, List<Point> posOfPathPossible) {
		this.mapSize = mapSize;
		this.posAvatar = posAvatar;
		this.posLight = posLight;
		this.posOfPathPossible = posOfPathPossible;
	}

	public Point getMapSize() {
		return mapSize;
	}

	public void setMapSize(Point mapSize) {
		this.mapSize = mapSize;
	}

	public Point getPosAvatar() {
		return posAvatar;
	}

	public void setPosAvatar(Point posAvatar) {
		this.posAvatar = posAvatar;
	}

	public Point getPosLight() {
		return posLight;
	}

	public void setPosLight(Point posLight) {
		this.posLight = posLight;
	}

	public List<Point> getPosOfPathPossible() {
		return posOfPathPossible;
	}

	public void setPosOfPathPossible(List<Point> posOfPathPossible) {
		this.posOfPathPossible = posOfPathPossible;
	}
}
