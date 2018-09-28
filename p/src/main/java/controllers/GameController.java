package controllers;

import java.util.List;

import commands.ICommand;
import model.Map;

public class GameController {
	private Map map;
	
	public GameController(Map map) {
		this.map = map;
	}

	public void run(List<ICommand> actionsCommand) {
		for (ICommand command : actionsCommand) {
			command.executeCommand(this.map);
		}
		this.map.printMap();
	}

	/** Leer la colección de las acciones. */

	/** Crear un sleep de un segundo, por cada instrucción que se ejecute. */

	/**
	 * Validar que las acciones o instrucciones, para controlar el movimiento del
	 * avatar, controle que el avatar pertenezca al camino posible y no salga del
	 * mismo.
	 */

	/**
	 * Evaluar estado de las luces, si quedó alguna apagada, entonces “perdiste”, en
	 * caso contrario,que todas las luces queden encendidas, entonces el player ganó
	 * el juego.
	 */

}
