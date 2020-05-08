package project;
import main.Frame;
import main.Hero;
import main.Window;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
public class Main {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static Socket socket;
    public static Window frame ;
    public static Frame frame1;


    public static void main(String[]args){


        //Arena midlane = new Arena(antimage, facelessvoid, 400);
        //System.out.println(midlane);
        //Frame page1 = new Frame(new Animation(midlane));
        //page1.setVisible(true);
        //System.out.println(midlane);
 frame =  new Window();



    }
    public static void connectToServer(){
        try {
            Socket socket = new Socket("127.0.0.1",5009);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }catch (Exception e){e.printStackTrace();}
    }

    public static void addGeroi(Hero hero) {
                PackageData data = new PackageData();
                data.setOperationType("add");
                data.setHero(hero);
                try {
                    outputStream.writeObject(data);
                } catch (IOException e) {
                    e.printStackTrace();
        }

    }
}
