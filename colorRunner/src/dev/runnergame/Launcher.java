package dev.runnergame;

public class Launcher {
	public static void main(String[] args) {
		SingletonController game = SingletonController.getInstance("ColorRunner", 640, 360);
		game.start();
	}
}
