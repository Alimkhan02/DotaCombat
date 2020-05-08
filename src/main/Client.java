package main;

import com.sun.xml.internal.ws.wsdl.writer.document.Import;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    private static Socket connection;
    private static ObjectInputStream input;
    private static ObjectOutputStream output;
    private static String address = "Localhost";
    private static int port = 8000;
    Frame page;

    public static void main(String[] args) {
        try {
            connection = new Socket(address, port);
            input = new ObjectInputStream(connection.getInputStream());
            output = new ObjectOutputStream(connection.getOutputStream());
            System.out.println("connected");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
