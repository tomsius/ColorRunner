package dev.runnergame.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import dev.runnergame.Controller;


public class ServerConnection implements Runnable {
	private Socket server;
	private BufferedReader in;
	private Controller controller;
	
	public ServerConnection(Socket s, Controller controller) throws IOException {
		server = s;
		in = new BufferedReader(new InputStreamReader(server.getInputStream()));
		this.controller = controller;
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
				
				controller.drawOpponent(parts[0], parts[1]);
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
