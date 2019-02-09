import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8070);

        try(
            Socket clientSocket = socket.accept();
            BufferedReader bf = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);){
            String line = bf.readLine();
            System.out.println("Recieved from client: " + line);
            pw.println("Hello client");

        }
socket.close();
    }
}
