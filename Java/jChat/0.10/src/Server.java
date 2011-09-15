import java.io.*;
import java.net.*;

public class Server implements Runnable{
	private ServerSocket serverSocket;
	private Socket connection = null;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String message;
	
	public Server() {
		try {
			serverSocket = new ServerSocket(2004); // Creo un socket
			System.out.println("Attendo una connessione...");
		}
		catch(IOException e) {}
	}
	
	private void start() {
		while(true) {
			try {
				connection = serverSocket.accept(); // Accetto le connessioni in arrivo
				System.out.println("Connessione ricevuta da " + connection.getInetAddress().getHostName());
				new Thread(this).start();
			}
			catch(IOException e) {}
		}
	}
	
	public void run() {
		while(true) {
			try {
					/* Ottengo gli stream I/O */
					out = new ObjectOutputStream(connection.getOutputStream());
					out.flush();
					in = new ObjectInputStream(connection.getInputStream());
					sendMessage("Server message: Benvenuto in jChat\n", false);
		
					/* Inizio la comunicazione */
					do {
						message = (String)in.readObject();
						System.out.println(connection.getInetAddress().getHostName()+">" + message);
						if (message.equals("|")) {
							sendMessage(connection.getInetAddress().getHostName()+" disconnesso.\n", true);
						}
					} while(!message.equals("|"));
			}
			catch(ClassNotFoundException e) {}
			catch(IOException e) {}
		}
	}
	
	private void closeSocket() {
		try {
			in.close();
			out.close();
			serverSocket.close();
		}
		catch(IOException e) {}
	}
	
	private void sendMessage(String text, boolean view) {
		try {
			out.writeObject(text);
			out.flush();
			if(view == true) {
				System.out.println(text);
			}
		}
		catch(IOException e) {}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
}
