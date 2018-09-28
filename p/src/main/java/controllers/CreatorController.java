package controllers;

import java.util.ArrayList;
import java.util.List;

import board.CreateMap;
import commands.ICommand;
import main.Constants;
import model.Map;

public class CreatorController {
	private Map map;
	private JsonController jsonController;
	private TxtController txtController;
	private List<ICommand> actionsCommand;
	private GameController gameController;

	public CreatorController() {
		this.actionsCommand = new ArrayList<ICommand>();
	}

	public void createMap() {
		CreateMap create = new CreateMap(Constants.ROUTE_MAP_PROPERTIES);
		this.map = create.getMap();
		this.map.getBoard().printBoard();

	}

	public void createActionsByJson() {
		this.jsonController = new JsonController(Constants.ROUTE_JSON_INSTRUCTIONS_1);
		this.jsonController.createColecctionOfActions();
		this.actionsCommand = this.jsonController.getActionsCommand();
	}

	public void createActionsByTxt() {
		this.txtController = new TxtController();
		this.txtController.createColecctionOfActions();
		this.actionsCommand = this.txtController.getActionsCommand();
	}

	public void runActions() {
		this.gameController = new GameController(this.map);
		this.gameController.run(this.actionsCommand);
	}

	public Map getMap() {
		return map;
	}
}