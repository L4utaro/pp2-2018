package board;

import classProperties.MapProperties;
import model.Map;

public class CreateMap {
	private Map map;
	private MapProperties mapProperties;
	
	public CreateMap (String route_properties) {
		mapProperties = new MapProperties(route_properties);
		createMap();
	}
	
	private void createMap() {
		map = new Builder(mapProperties.getElectionMap().getMapSize())
				.whitRoadPossible(mapProperties.getElectionMap().getPosOfPathPossible())
				.whitLights(mapProperties.getElectionMap().getPosLight())
				.whitAvatar(mapProperties.getElectionMap().getPosAvatar())
				.build();
	}

	public Map getMap() {
		return map;
	}

	public MapProperties getMapProperties() {
		return mapProperties;
	}
}
