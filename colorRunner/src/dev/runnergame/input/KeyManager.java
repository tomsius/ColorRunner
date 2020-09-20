package dev.runnergame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	private boolean[] keys;
	public boolean up, down, left, right;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void update() {
		up = keys[KeyEvent.VK_W];		// kai spaudzia W
		down = keys[KeyEvent.VK_S];		// kai spaudzia S
		left = keys[KeyEvent.VK_A];		// kai spaudzia A
		right = keys[KeyEvent.VK_D];	// kai spaudzia D
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
