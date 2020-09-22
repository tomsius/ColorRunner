package dev.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private ArrayList<ClientHandler> clients;
	private int clientId;
	private int anotherClient;
	
	public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients, int id) throws IOException {
		this.client = clientSocket;
		this.clients = clients;
		this.clientId = id;
		this.anotherClient = id == 0? 1: 0;
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(), true);
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				String msg = in.readLine();
				
				if(msg == null) {
					continue;
				}
				
				String[] parts = msg.split(" ");
				if(msg.contains("coordinates")) {
					//out.println("Server got: (" + parts[1] + "; " + parts[2] + ")");
					clients.get(anotherClient).out.println(parts[1] + " " + parts[2]);
				}
				else {
					out.println("Command not found");
				}
			}
		} catch (IOException e) {
			System.err.println("Exception in ClientHandler");
			e.printStackTrace();
		} finally {
			out.close();
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
