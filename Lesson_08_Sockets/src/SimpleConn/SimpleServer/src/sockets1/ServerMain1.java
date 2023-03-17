package SimpleConn.SimpleServer.src.sockets1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain1 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1235);

        Socket socket = serverSocket.accept();
        System.out.println("Client connected from " + socket.getInetAddress().getHostAddress() + " " + socket.getLocalPort());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out.println("Hello from server. Write your name");
        String nameFromClient = in.readLine();
        out.println("Hello " + nameFromClient);
        out.println("Please give me a string to uppercase");
        String stringFormClient = in.readLine();
        out.println(stringFormClient.toUpperCase());
    }
}
