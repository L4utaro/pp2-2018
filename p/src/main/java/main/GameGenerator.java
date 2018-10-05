package main;

import java.util.ArrayList;
import java.util.List;

import board.CreateMap;
import commands.interfaces.ICommand;
import commands.invoker.InvokerCommand;
import controllers.GameController;
import lectors.implementation.JsonImplementation;
import lectors.implementation.TxtImplementation;
import model.Map;

public class GameGenerator {
	private Map map;
	private JsonImplementation jsonImplementation;
	private TxtImplementation txtImplementation;
	private List<ICommand> actionsCommand;
	private GameController gameController;
	private List<InvokerCommand> invokerCommands;

	//aca meti en invoker command
	
	public GameGenerator() {
		this.actionsCommand = new ArrayList<ICommand>();
		this.invokerCommands = new ArrayList<InvokerCommand>();
	}

	public void createMap() {
		CreateMap create = new CreateMap(Constants.ROUTE_MAP_PROPERTIES);
		this.map = create.getMap();
		this.map.getBoard().printBoard();

	}

	public void createActionsByJson() {
		this.jsonImplementation = new JsonImplementation(Constants.ROUTE_JSON_INSTRUCTIONS_1);
		this.jsonImplementation.createColecctionOfActions();
		this.actionsCommand = this.jsonImplementation.getActionsCommand();
		this.invokerCommands = this.jsonImplementation.getInvokerCommands();
	}

	public void createActionsByTxt() {
		this.txtImplementation = new TxtImplementation(Constants.ROUTE_TXT_INSTRUCTIONS_3);
		this.txtImplementation.createColecctionOfActions();
		this.actionsCommand = this.txtImplementation.getActionsCommand();
	}

	public void runActions() {
		this.gameController = new GameController(this.map);
		//this.gameController.run(this.actionsCommand);
		this.gameController.run2(this.invokerCommands);
	}

	public Map getMap() {
		return map;
	}
}