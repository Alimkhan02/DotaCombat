package main;
import java.net.*;
import java.sql.*;
import java.net.Socket;

public class Server {
    public static Connection connection;
    public static void main(String[] args) {
        try{
           // connectToDb();
            ServerSocket ss = new ServerSocket(8000);

            while(true){
                System.out.println("waiting for user");
                Socket socket = ss.accept();
                System.out.println("new user connected");

                ServerThread sth = new ServerThread(socket,connection);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    /*public static  void connectToDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/CreateHero?serverTimezone=UTC",
                            "root",
                            "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
