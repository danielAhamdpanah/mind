package clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Inputs {
/*
    public static void main(String[] args) throws IOException {
        Inputs inputs = new Inputs();
    }
 */
    public Inputs () throws IOException {
        Socket socket = new Socket("localhost",8000);
        //DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dot = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        dot.writeUTF(str);

    }

}
