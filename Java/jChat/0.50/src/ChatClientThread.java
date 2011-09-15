import java.net.*;
import java.io.*;

public class ChatClientThread extends Thread {
	private Socket socket;
	private ChatClient client;
	private DataInputStream input;

	public ChatClientThread(ChatClient _client, Socket _socket) {
		client = _client;
		socket = _socket;
		open();  
		start();
	}
	
	public void open() {
		try {
			input = new DataInputStream(socket.getInputStream());
		}
		catch(IOException e) {
			System.out.println("Error getting input stream: "+e);
			client.stop();
		}
	}
	
	public void close() {
		try {
			if(input != null) {
				input.close();
			}
		}
		catch(IOException e) {
			System.out.println("Error closing input stream: "+e);
		}
	}
	
	public void run() {
		while(true) {
			try {
				client.handle(input.readUTF());
			}
			catch(IOException e) {
				System.out.println("Listening error: " + e.getMessage());
				client.stop();
			}
		}
	}
}
