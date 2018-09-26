package executors;

import model.Map;

public class CommandLight implements ICommand{

	@Override
	public void executeCommand(Map map) {
		map.getBox(map.getAvatarPos()).changeStateLight();
	}

}
