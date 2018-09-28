package main;

import controllers.CreatorController;

public class Main {

	public static void main(String[] args) {
		CreatorController creator = new CreatorController();
		creator.createMap();
		creator.createActionsByJson();
		creator.runActions();
	}
}
