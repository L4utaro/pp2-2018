package classProperties;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MapProperties {
	private Properties properties;
	private ElectionMap electionMap;

	public MapProperties(String route_properties) {
		this.properties = new Properties();
		loadProperties(route_properties);
		loadDataProperties();
	}
	
	private void loadDataProperties() {
		Point mapSize = loadSizeMap();
		Point posAvatar = loadPositionAvatar();
		Point posLight = loadPositionLight();
		//List<Point> posOfPathPossible = loadPosistionsOfPathPossible();
		this.electionMap = new ElectionMap(mapSize, posAvatar, posLight, posOfPathPossible);
	}

	private Point loadSizeMap() {
		return new Point(Integer.parseInt(properties.getProperty("heightMap")),
				Integer.parseInt(properties.getProperty("widthMap")));
	}
	
	private Point loadPositionAvatar() {
		return getPointOfProperties("posAvatar");
	}
	
	private Point loadPositionLight() {
		return getPointOfProperties("posLight");
	}

	private List<Point> loadPosistionsOfPathPossible(String parameter) {
		List<Point> posOfPathPossible = new ArrayList<Point>();
		for(int i = 1; i < parameter.length()-1; i++) {
			posOfPathPossible.add(new Point(properties.getProperty(parameter).charAt(1), properties.getProperty(parameter).charAt(3)));
		}
		
		return posOfPathPossible;
	}
	
	private Point getPointOfProperties(String parameter) {
		return new Point(properties.getProperty(parameter).charAt(1), properties.getProperty(parameter).charAt(3));
	}

	private void loadProperties(String route_properties) {
		try {
			this.properties.load(new FileReader(route_properties));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ElectionMap getElectionMap() {
		return electionMap;
	}
}
