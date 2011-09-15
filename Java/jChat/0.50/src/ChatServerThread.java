import java.net.*;
import java.io.*;

public class ChatServerThread extends Thread {
        private ChatServer server;
        private Socket socket;
        private int id;
        private DataInputStream streamIn;
        private DataOutputStream streamOut;

        public ChatServerThread(ChatServer _server, Socket _socket) {
                super();
                server = _server;
                socket = _socket;
                id = socket.getPort();
        }
        
        public void send(String text) {
                try {
                        streamOut.writeUTF(text);
                        streamOut.flush();
                }
                catch(IOException e) {
                        System.out.println(id + " ERROR sending: " + e.getMessage());
                        server.remove(id);
                        stop();
                }
        }
        
        public int getID() {
                return id;
        }
        
        public void run() {
                System.out.println("Server Thread "+id+" running.");
                while(true) {
                        try {
                             server.handle(id, streamIn.readUTF());
                        }
                        catch(IOException e) {
                                System.out.println(id+" ERROR reading: "+e.getMessage());
                                server.remove(id);
                                stop();
                        }
                }
        }
        
        public void open() throws IOException {
                streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                streamOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        }
        
        public void close() throws IOException {
                if(socket != null) {
                        socket.close();
                }
                if(streamIn != null) {
                        streamIn.close();
                }
                if(streamOut != null) {
                        streamOut.close();
                }
       }
}
