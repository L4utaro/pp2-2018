package main;

import board.CreateMap;
import model.Map;

public class Game {

    private Map map;

    public Game() {
    }

    public void initMap() {
        CreateMap create = new CreateMap(Constants.ROUTE_MAP_PROPERTIES);
        this.map = create.getMap();
        this.map.getBoard().printBoard();
    }

	public Map getMap() {
		return map;
	}
}