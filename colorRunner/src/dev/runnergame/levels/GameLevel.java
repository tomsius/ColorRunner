package dev.runnergame.levels;

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
	private int size;
	private EffectCreator effectFactory;
	private AbstractStructureFactory platformFactory;
	private AbstractStructureFactory obstacleFactory;
	private List<Object> objects;
	private float spawnX, spawnY;
	
	public GameLevel(String path) {
		effectFactory = SingletonController.getInstance("ColorRunner", 640, 360).getEffectFactory();
		platformFactory = SingletonController.getInstance("ColorRunner", 640, 360).getPlatformFactory();
		obstacleFactory = SingletonController.getInstance("ColorRunner", 640, 360).getObstacleFactory();
		loadWorld(path);
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < size; i++) {
			if(objects.get(i) instanceof Effect) {
				((Effect) objects.get(i)).render(g);
			}
			else if(objects.get(i) instanceof Structure) {
				((Structure) objects.get(i)).render(g);
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
					if(tokens[1].equals("positive")) {
						objects.add(effectFactory.createEffect("positive", Utils.parseFloat(tokens[2]), Utils.parseFloat(tokens[3])));
					}
					else if(tokens[1].equals("negative")) {
						objects.add(effectFactory.createEffect("negative", Utils.parseFloat(tokens[2]), Utils.parseFloat(tokens[3])));
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
}
