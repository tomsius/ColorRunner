package dev.runnergame.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import dev.runnergame.SingletonController;


public class ServerConnection implements Runnable {
	private Socket server;
	private BufferedReader in;
	private SingletonController controller;
	
	public ServerConnection(Socket s) throws IOException {
		server = s;
		in = new BufferedReader(new InputStreamReader(server.getInputStream()));
		this.controller = SingletonController.getInstance("ColorRunner", 640, 360);
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				String serverResponse = in.readLine();
				
				if(serverResponse == null) {
					break;
				}
				String[] parts = serverResponse.split(" ");
				//System.out.println("Server says: " + serverResponse);
				
				controller.drawOpponent(parts[0], parts[1], parts[2], parts[3]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
