package MultipleClientConnects.client;

import java.io.IOException;

public class RunClient
{

    public static void main(String[] args) throws IOException
    {
        SocketClient client = new SocketClient();
        client.start();
    }
}

//        Socket socket = new Socket("127.0.0.1", 1235);
//        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(socket.getInputStream()));
//
//        String message = in.readLine();
//        System.out.println(message);
//        String name = new Scanner(System.in).nextLine();
//        out.println(name);
//        message = in.readLine();
//        System.out.println(message);
//
//        String string;
////        do
////        {
////            message = in.readLine();
////            System.out.println(message);
////            string = new Scanner(System.in).nextLine();
////            out.println(string);
////            message = in.readLine();
////            System.out.println(message);
////        } while (!string.equals("exit") && !string.equals("stop"));
