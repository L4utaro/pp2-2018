package main;

import board.CreateMap;
import controllers.JsonController;
import model.Map;

public class Game {
	private Map map;
	private JsonController jsonController;

	public Game() {

	}

	public void initMap() {
		CreateMap create = new CreateMap(Constants.ROUTE_MAP_PROPERTIES);
		this.map = create.getMap();
		this.map.getBoard().printBoard();
		this.jsonController = new JsonController(Constants.ROUTE_JSON_INSTRUCTIONS);
		this.jsonController.createColecctionOfActions();
		System.out.println("Cantidad de acciones: " + this.jsonController.getActions().size());
	}

	public Map getMap() {
		return map;
	}
}