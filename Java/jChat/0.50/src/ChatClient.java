import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatClient implements Runnable {
        private Socket socket;
        private Thread thread;
        private DataInputStream input;
        private DataOutputStream output;
        private ChatClientThread client;
        private String host;
        private int port;
        private Scanner scanner;
   
        public ChatClient(String host, int port) {
                this.host = host;
                this.port = port;
 		start();
 	}
   
        public ChatClient() {
                this.host = "localhost";
                this.port = 2004;
 		start();
 	}

        public void start() {
        	try {
			/* Creo il socket e lo scanner */
			socket = new Socket(host, port);
			scanner = new Scanner(System.in);
			
			/* Creo gli stream I/O e gli oggetti per gestire i thread */
		        input = new DataInputStream(System.in);
		        output = new DataOutputStream(socket.getOutputStream());
		        client = new ChatClientThread(this, socket);
		        thread = new Thread(this);
		        thread.start();
		}
		catch(IOException e) {}
        }
   
        public void stop() {
        	try {
			/* Se gli oggetti non sono nulli li chiudo o li interrompo */
		        if(thread != null) {
		                thread.stop();
		        }
		        
		        if(input != null) {
		                input.close();
		        }
		        
		        if(output != null) {
		                output.close();
		        }
		        
		        if(socket != null) {
		                socket.close();
		        }
		        
		        client.close();  
		        client.stop();
		}
		catch(IOException e) {}
        }
        
        public void run() {
                while(thread != null) {
                        try {
                                output.writeUTF(input.readLine());
                                output.flush();
                        }
                        catch(IOException e) {
                                System.out.println("Errore: "+e.getMessage());
                                stop();
                        }
                }
        }
        
        public void handle(String text) {
                if(text.equals("|")) {
                        stop();
                }
                else {
                        System.out.println(text);
                }
        }
        
	public static void main(String[] args) {
	        ChatClient client;
	        Scanner scanner = new Scanner(System.in);
		String host, choice;
		int port;
		
		System.out.println("Vuoi avviare il client di jChat con le configurazioni di default o vuoi configurarle manualmente? (d/m) ");
		choice = scanner.next();
		
		if(choice.equals("d")) {
		               client = new ChatClient();
		}
		else if(choice.equals("m")) {
		        System.out.println("Host");
		        host = scanner.next();
		        System.out.println("Porta");
		        port = scanner.nextInt();
		        client = new ChatClient(host, port);
                }
	}
}
