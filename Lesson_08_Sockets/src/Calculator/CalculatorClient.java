package Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient
{
  public static void main(String[] args) throws IOException
  {

    Socket socket = new Socket("127.0.0.1", 1209);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));

    String message = in.readLine();
    System.out.println(message);
    String operation = new Scanner(System.in).nextLine();
    out.println(operation);
    message = in.readLine();
    System.out.println(message);
  }
}
