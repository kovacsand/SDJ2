package Ex_11_5.Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain1
{
    private Pool pool = new Pool();

    public void start()
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(1209);

            int id= 0;

            while(true)
            {
                System.out.println("Waiting for a client...");
                Socket socket = serverSocket.accept();
                System.out.println(
                    "Client connected from " + socket.getInetAddress().getHostAddress() + " " + socket.getLocalPort());

                ServerSocketHandler serverSocketHandler = new ServerSocketHandler(
                    socket,id, this);
                pool.addConn(serverSocketHandler);

                Thread thread = new Thread(serverSocketHandler);
                thread.start();

                id++;


            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }

    public Pool getPool()
    {
        return pool;
    }
}
