package main;

import board.CreateMap;
import model.Map;

public class Game {

    private Map map;

    public Game() {
    }

    public void initMap() {
        CreateMap create = new CreateMap(Constants.ROUTE_PROPERTIES);
        this.map = create.getMap();
    }

	public Map getMap() {
		return map;
	}
}