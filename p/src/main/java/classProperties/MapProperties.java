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
		List<Point> posLight = loadPositionsOfPoint("posLight");
		List<Point> posOfPathPossible = loadPositionsOfPoint("pathPossible");
		this.electionMap = new ElectionMap(mapSize, posAvatar, posLight, posOfPathPossible);
	}

	private Point loadSizeMap() {
		return new Point(Integer.parseInt(properties.getProperty("heightMap")),
				Integer.parseInt(properties.getProperty("widthMap")));
	}
	
	private Point loadPositionAvatar() {
		return getPointOfProperties("posAvatar");
	}

	private List<Point> loadPositionsOfPoint(String parameter) {
		List<Point> posOfPathPossible = new ArrayList<Point>();
		for(int i = 1; i < properties.getProperty(parameter).length()-2; i++) {
			posOfPathPossible.add(new Point(properties.getProperty(parameter).charAt(i+1) - '0', properties.getProperty(parameter).charAt(i+3) - '0'));
			i+=6;
		}
		return posOfPathPossible;
	}
	
	private Point getPointOfProperties(String parameter) {
		return new Point(properties.getProperty(parameter).charAt(1) - '0', properties.getProperty(parameter).charAt(3) - '0');
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
