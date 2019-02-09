import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {

        InetAddress inetIp = InetAddress.getByName("localhost");

        try (
                //произойдет ошибка если нет такого сервер слушателя на таком хосте и порту
                Socket clientSocket = new Socket(inetIp, 8070);
                BufferedReader bf = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true)) {

            //отсылаем строку на сервер
            pw.println("Hello server");

            //получаем строку от сервер
            String line = bf.readLine();

            System.out.println("Received from server " + line);
        }
    }
}
