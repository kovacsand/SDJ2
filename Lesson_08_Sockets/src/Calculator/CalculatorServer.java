package Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {

  public static void main(String[] args) throws IOException
  {
    try (
        ServerSocket serverSocket = new ServerSocket(1209);
    ) {
      while (true) {
        try (
            Socket socket = serverSocket.accept();
        ) {
          PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          System.out.println("Client connected from " + socket.getInetAddress().getHostAddress() + " " + socket.getPort());
          out.println("Hello from server. Write your operation like this (3 + 5) Only integers work");
          String operation[] = in.readLine().split(" ");
          if (operation[1].equals("/") && operation[2].equals("0"))
            out.println("You are dummy dumb");
          else
          {
            switch (operation[1])
            {
              case "+":
                out.println(Integer.parseInt(operation[0]) + Integer.parseInt(operation[2]));
                break;
              case "-":
                out.println(Integer.parseInt(operation[0]) - Integer.parseInt(operation[2]));
                break;
              case "*":
                out.println(Integer.parseInt(operation[0]) * Integer.parseInt(operation[2]));
                break;
              case "/":
                out.println(Integer.parseInt(operation[0]) / Integer.parseInt(operation[2]));
                break;
            }
          }
        }
      }
    }
  }
}