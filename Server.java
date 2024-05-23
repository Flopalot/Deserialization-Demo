import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server listening on port 12345...");
            while (true) {
                try (Socket socket = serverSocket.accept();
                     ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
                    
                    Object obj = ois.readObject();
                    System.out.println("Received object: " + obj);

                    // Simulating processing of the deserialized object
                    if (obj instanceof Exploitable) {
                        ((Exploitable) obj).execute();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

interface Exploitable {
    void execute();
}