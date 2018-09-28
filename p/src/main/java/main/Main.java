package main;

public class Main {

	public static void main(String[] args) {
		GameGenerator creator = new GameGenerator();
		creator.createMap();
		creator.createActionsByJson();
		creator.runActions();
	}
}
