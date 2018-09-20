package validators;

import org.json.simple.JSONArray;

import enums.Actions;

public class ValidatorJson implements IValidator {

	public boolean validateInstructionsOfJsonArray(JSONArray actionsJson) {
		for (int i = 0; i < actionsJson.size(); i++) {
			if (checkInstruction(actionsJson.get(i).toString())) {
				return false;
			}
		}
		return true;
	}

	public boolean checkInstruction(String instruction) {
		return Actions.values().toString().contains(instruction);
	}
}
