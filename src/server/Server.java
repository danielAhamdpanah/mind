package server;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    ServerSocket serverSocket;

    public Server () throws IOException {
        Thread thread = new Thread(this::run);
        thread.start();
    }


    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            DataInputStream din = null;
            try {
                din = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                DataOutputStream dot = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            String command = null;
            try {
                command = din.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(command);
        }
    }
}
