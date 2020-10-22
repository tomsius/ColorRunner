package dev.runnergame.levels;

import dev.runnergame.command.MoveCommandInvoker;
import dev.runnergame.command.MoveDownCommand;
import dev.runnergame.command.MoveLeftCommand;
import dev.runnergame.command.MoveRightCommand;
import dev.runnergame.command.MoveUpCommand;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import dev.runnergame.SingletonController;
import dev.runnergame.abstractFactory.AbstractStructureFactory;
import dev.runnergame.entities.Effect;
import dev.runnergame.entities.Structure;
import dev.runnergame.factory.EffectCreator;
import dev.runnergame.utils.Utils;

public class GameLevel {
	private SingletonController controller;
	private int size;
	private EffectCreator effectFactory;
	private AbstractStructureFactory platformFactory;
	private AbstractStructureFactory obstacleFactory;
	private List<Object> objects;
	private float spawnX, spawnY;
	
	public GameLevel(String path) {
		this.controller = SingletonController.getInstance("ColorRunner", 640, 360);
		effectFactory = controller.getEffectFactory();
		platformFactory = controller.getPlatformFactory();
		obstacleFactory = controller.getObstacleFactory();
		loadWorld(path);
	}
	
	public void update() {
		for(int i = 0; i < size; i++){
			if(objects.get(i) instanceof Structure) {
				Structure structureItem = (Structure) objects.get(i);
				MoveCommandInvoker moveCommandInvoker = new MoveCommandInvoker(new MoveUpCommand(structureItem),
					new MoveRightCommand(structureItem),
					new MoveDownCommand(structureItem),
					new MoveLeftCommand(structureItem));
				moveCommandInvoker.moveLeft();
				structureItem.update();
			}
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < size; i++) {
			if(objects.get(i) instanceof Effect) {
				float x = ((Effect) objects.get(i)).getX();
				((Effect) objects.get(i)).render(g, (int) (x - controller.getGameCamera().getxOffset()));
			}
			else if(objects.get(i) instanceof Structure) {
				float x = ((Structure) objects.get(i)).getX();
				((Structure) objects.get(i)).render(g, (int) (x - controller.getGameCamera().getxOffset()));
			}
		}
	}
	
	private void loadWorld(String path) {
		Utils.loadFileAsString(path);
		String[] tokens = Utils.getLine(0).split(" ");
		size = Utils.parseInt(tokens[0]);		// objektu lygyje skaicius
		objects = new ArrayList<Object>(size);
		
		tokens = Utils.getLine(1).split(" ");
		spawnX = Utils.parseFloat(tokens[0]);		// zaidejo x koordinate
		spawnY = Utils.parseFloat(tokens[1]);		// zaidejo y koordinate
		
		for(int i = 2; i < size + 2; i++) {
			if(Utils.hasLinesLeft()) {
				tokens = Utils.getLine(i).split(" ");
				
				// efektu kurimas
				if(tokens[0].equals("effect")) {
					if(tokens[1].equals("fly")) {
						objects.add(effectFactory.createEffect("fly", Utils.parseFloat(tokens[2]), Utils.parseFloat(tokens[3])));
					}
					else if(tokens[1].equals("slide")) {
						objects.add(effectFactory.createEffect("slide", Utils.parseFloat(tokens[2]), Utils.parseFloat(tokens[3])));
					}
					else if(tokens[1].equals("stun")) {
						objects.add(effectFactory.createEffect("stun", Utils.parseFloat(tokens[2]), Utils.parseFloat(tokens[3])));
					}
					else {
						continue;
					}
				}
				
				// kliuciu kurimas
				else if(tokens[0].equals("obstacle")) {
					if(tokens[1].equals("standard")) {
						objects.add(obstacleFactory.getStructure("standard", Utils.parseFloat(tokens[2]), Utils.parseFloat(tokens[3])));
					}
					else if(tokens[1].equals("disappearing")) {
						objects.add(obstacleFactory.getStructure("disappearing", Utils.parseFloat(tokens[2]), Utils.parseFloat(tokens[3])));
					}
					else {
						continue;
					}
				}
				
				// platformu kurimas
				else if(tokens[0].equals("platform")) {
					if(tokens[1].equals("standard")) {
						objects.add(platformFactory.getStructure("standard", Utils.parseFloat(tokens[2]), Utils.parseFloat(tokens[3])));
					}
					else if(tokens[1].equals("disappearing")) {
						objects.add(platformFactory.getStructure("disappearing", Utils.parseFloat(tokens[2]), Utils.parseFloat(tokens[3])));
					}
					else {
						continue;
					}
				}
				else {
					continue;
				}
			}
		}
	}

	public List<Effect> getLevelEffects() {
		List<Effect> effectList = new ArrayList<Effect>();

		for(int i = 0; i < size; i++) {
			if(objects.get(i) instanceof Effect) {
				effectList.add((Effect) objects.get(i));
			}
		}

		return effectList;
	}
}
