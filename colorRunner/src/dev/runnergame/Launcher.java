package dev.runnergame;

public class Launcher {
	public static void main(String[] args) {
		Controller game = Controller.getInstance("ColorRunner", 640, 360);
		game.start();
	}
}
