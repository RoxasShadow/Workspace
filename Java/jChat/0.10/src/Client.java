import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	private boolean defaultSettings;
	private String host, port;
	private Socket socket;
	private ObjectOutputStream output;
 	private ObjectInputStream input;
 	private String message, text;
 	private Scanner scanner;
 	
 	public Client(String host, String port) {
 		this.host = host;
 		this.port = port;
 		defaultSettings = false;
 		run();
 	}
 	
 	public Client() {
 		host = "localhost";
 		port = "2004";
 		defaultSettings = true;
 		run();
 	}
 	
	private void run() {
		try {
			/* Creo il socket e lo scanner */
			socket = new Socket(host, Integer.parseInt(port));
			scanner = new Scanner(System.in);
			
			if(defaultSettings == false) {
				System.out.println("Connesso a "+host+" sulla porta "+port);
			}
			else {
				System.out.println("Non è stato dato come argomento nessun host e nessuna porta: uso quelli di default.\nConnesso all'host "+host+" sulla porta "+port);
			}
			
			/* Ottengo gli stream I/O */
			output = new ObjectOutputStream(socket.getOutputStream());
			output.flush();
			input = new ObjectInputStream(socket.getInputStream());
			
			/* Resto in attesa dei messaggi che invio e ricevo al/dal server */
			while(true) {
				message = (String)input.readObject();
				System.out.println(message);
				
				text = scanner.next();
				sendMessage(text);
			}			
			
		}
		catch(ClassNotFoundException classNot) {
			System.err.println("Il formato del messaggio è sconosciuto.");
		}
		catch(UnknownHostException unknownHost) {
			System.err.println("Stai provando a connetterti ad un host sconosciuto.");
		}
		catch(IOException ioException) {
			ioException.printStackTrace();
		}
		finally {
			try {
				/* Chiudo le connessioni */
				input.close();
				output.close();
				socket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
	void sendMessage(String msg) {
		try {
			/* Invio il messaggio al server */
			output.writeObject(msg);
			output.flush();
		}
		catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Client client;
		if((args.length == 1)  && (args[0].equals("--help"))) {
			System.out.println("Usage: java Client <ip default:localhost> <port default:2004>");
		}
		else if(args.length == 2) {
			client = new Client(args[0], args[1]);
		}
		else {
			client = new Client();
		}
	}
}
