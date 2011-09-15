import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatServer implements Runnable {
        private ChatServerThread clients[];
        private ServerSocket server;
        private Thread thread;
        private int port, maxClient, clientCount;
        
        public ChatServer(int port, int clients) {
                this.port = port;
                this.maxClient = maxClient;
 		start();
 	}
        
        public ChatServer() {
                this.port = 2004;
                this.maxClient = 50;
 		start();
 	}
        
        public void start() {
        	try {
        		server = new ServerSocket(port);
        		clients = new ChatServerThread[maxClient];
        		thread = new Thread(this);
        		thread.start();
        	}
        	catch(IOException e) {}
        }
	
	public void run() {
	        while(thread != null) {
	                try {
                                System.out.println("Attendo una connessione...");
                                addThread(server.accept());
                        }
                        catch(IOException e) {}
                }
        }
        
        public void stop() {
                if(thread != null) {
                        thread.stop();
                        thread = null;
                }
        }
       
        private int findClient(int id) {
                for(int i=0; i<clientCount; i++) {
                        if(clients[i].getID() == id) {
                                return i;
                        }
                }
                return -1;
        }
        
        public synchronized void handle(int id, String input) {
                if(input.equals("|")) {
                        clients[findClient(id)].send("|");
                        remove(id);
                }
                else {
                        for(int i=0; i<clientCount; i++) {
                                clients[i].send(id+": "+input);
                        }
			System.out.println(id+": "+input);
                }
        }
        
        public synchronized void remove(int id) {
                int pos = findClient(id);
                if(pos >= 0) {
                        ChatServerThread toTerminate = clients[pos];
                        System.out.println("Rimozione processo del client " + id + " a " + pos);
                        if (pos < clientCount-1) {
                                for(int i=pos+1; i<clientCount; i++) {
                                        clients[i-1] = clients[i];
                                }
                                clientCount--;
                        }
                        try {
                                toTerminate.close();
                        }
                        catch(IOException e) {
                                System.out.println("Error closing thread: "+e);
                        }
                        toTerminate.stop();
                }
        }
        
        private void addThread(Socket socket) {
                if(clientCount < clients.length) {
                        System.out.println("Client accettato: "+socket);
                        clients[clientCount] = new ChatServerThread(this, socket);
                        try {
                                clients[clientCount].open();
                                clients[clientCount].start();
                                clientCount++;
                        }
                        catch(IOException e) {
                                System.out.println("Errore nell'apertura del processo: "+e);
                        }
                }
                else {  
                        System.out.println("Client rifiutato: massimo "+clients.length+" accettati.");
                }
        }
        
	public static void main(String[] args) {
	        ChatServer server;
	        Scanner scanner = new Scanner(System.in);
		String choice;
		int port, maxClient;
		
		System.out.println("Vuoi avviare il server di jChat con le configurazioni di default o vuoi configurarle manualmente? (d/m) ");
		choice = scanner.next();
		
		if(choice.equals("d")) {
		               server = new ChatServer();
		}
		else if(choice.equals("m")) {
		        System.out.println("Porta");
		        port = scanner.nextInt();
		        System.out.println("Client massimi");
		        maxClient = scanner.nextInt();
		        server = new ChatServer(port, maxClient);
                }
	}
}
