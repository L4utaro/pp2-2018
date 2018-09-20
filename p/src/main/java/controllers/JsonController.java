package controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import enums.Actions;
import json.LectorJson;
import validators.ValidatorJson;

public class JsonController {
	private LectorJson lectorJson;
	private JSONArray actionsJson;
	private ValidatorJson validatorJson;
	private List<Actions> actions;

	public JsonController(String routeJson) {
		this.lectorJson = new LectorJson(routeJson);
		this.actionsJson = (JSONArray) this.lectorJson.getListOfJson("actions");
		this.validatorJson = new ValidatorJson();
		this.actions = new ArrayList<Actions>();
	}

	public void createColecctionOfActions() {
		if (this.validatorJson.validateInstructionsOfJsonArray(this.actionsJson)) {
			System.out.println("las instrucciones son validas");
			for (int i = 0; i < this.actionsJson.size(); i++) {
				addAction(actionsJson.get(i).toString());
			}
		}
	}

	public void addAction(String action) {
		if (action.equals("avanzar"))
			this.actions.add(Actions.MOVE);
		else if (action.equals("izquierda"))
			this.actions.add(Actions.LEFT);
		else if (action.equals("derecha"))
			this.actions.add(Actions.RIGHT);
		else if (action.equals("luz"))
			this.actions.add(Actions.LIGHT);
	}

	public List<Actions> getActions() {
		return actions;
	}
}
