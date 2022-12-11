package Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static DataOutputStream dos;
    private static DataInputStream dis;
    private static ServerSocket serverSocket;


    public static void listenForServerRequest(boolean accepted) {
        Socket socket = null;
        try {
            socket = serverSocket.accept();
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            accepted = true;
            System.out.println("EL CLIENTE SOLICITO UNIRSE, Y SE LE ACEPTÓ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initializeServer(int port, String ip, boolean yourTurn, boolean circle) {
        try {
            serverSocket = new ServerSocket(port, 8, InetAddress.getByName(ip));
        } catch (Exception e) {
            e.printStackTrace();
        }
        yourTurn = true;
        circle = false;
    }

}
