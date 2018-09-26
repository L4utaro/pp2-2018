package main;

import board.CreateMap;
import controllers.JsonController;
import controllers.TxtController;
import model.Map;

public class Game {
	private Map map;
	private JsonController jsonController;
	private TxtController txtController;
	
	public Game() {

	}

	public void initMap() {
		CreateMap create = new CreateMap(Constants.ROUTE_MAP_PROPERTIES);
		this.map = create.getMap();
		this.map.getBoard().printBoard();
		this.jsonController = new JsonController(Constants.ROUTE_JSON_INSTRUCTIONS_1);
		this.jsonController.createColecctionOfActions();
		System.out.println("Cantidad de acciones: " + this.jsonController.getActionsCommand().size());
		this.txtController = new TxtController();
		this.txtController.createColecctionOfActions();
		System.out.println("Cantidad de acciones del txt: " + this.txtController.getActionsCommand().size());
		
	}

	public Map getMap() {
		return map;
	}
}