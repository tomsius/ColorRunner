package dev.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

  //	private static final int PORT = 9100; //9090
  private static final int PORT = 9091;

  private static ArrayList<ClientHandler> clients = new ArrayList<>();
  private static ExecutorService pool = Executors.newFixedThreadPool(2);

  public static void main(String[] args) throws IOException {
    ServerSocket listener = new ServerSocket(PORT);

    // laukia dvieju client
    while (clients.size() < 2) {
      System.out.println("Server is waiting for client connection...");
      Socket client = listener.accept();
      System.out.println("Client no. " + (clients.size() + 1) + " connected");
      ClientHandler clientThread = new ClientHandler(client, clients, clients.size());
      clients.add(clientThread);
    }

    // paleidzia atskira gija kiekvienam client
    for (ClientHandler ch : clients) {
      pool.execute(ch);
    }
  }
}
