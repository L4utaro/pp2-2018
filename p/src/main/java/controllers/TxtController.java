package controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import executors.CommandLeft;
import executors.CommandLight;
import executors.CommandMove;
import executors.CommandRight;
import executors.ICommand;
import lectors.LectorTxt;
import main.Constants;
import validators.ValidatorTxt;

public class TxtController {
	private LectorTxt lectorTxt;
	private JSONArray actionsJson;
	private ValidatorTxt validatorTxt;
	private List<ICommand> actionsCommand;

	public TxtController() {
		this.lectorTxt = new LectorTxt(Constants.ROUTE_TXT_INSTRUCTIONS_2);
		this.lectorTxt.readFile();
		this.actionsJson = (JSONArray) this.lectorTxt.getListOfJson("actions");
		this.validatorTxt = new ValidatorTxt();
		this.actionsCommand = new ArrayList<ICommand>();
	}

	public void createColecctionOfActions() {
		if (this.validatorTxt.validateInstructionsOfJsonArray(this.actionsJson)) {
			for (int i = 0; i < this.actionsJson.size(); i++) {
				addAction(actionsJson.get(i).toString());
			}
		} else {
			throw new IllegalArgumentException("The actions.txt contains wrong parameters");
		}
	}

	public void addAction(String action) {
		if (action.equals("move"))
			this.actionsCommand.add(new CommandMove());
		else if (action.equals("left"))
			this.actionsCommand.add(new CommandLeft());
		else if (action.equals("right"))
			this.actionsCommand.add(new CommandRight());
		else if (action.equals("light"))
			this.actionsCommand.add(new CommandLight());
	}

	public List<ICommand> getActionsCommand() {
		return actionsCommand;
	}
}
