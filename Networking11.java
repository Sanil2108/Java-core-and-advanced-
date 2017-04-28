import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Networking11 {
    //Program to create two threads, one will start a server and listen for connections
    //the other will try to connect to the server

    static int port = 1414;
    public static void startServer() throws Exception{

        ServerSocket ss=new ServerSocket(port);
        Socket s = ss.accept();

        System.out.println("Server started.\nListening for connections on port number "+port);

//        DataInputStream dis=new DataInputStream(s.getInputStream());
        InputStream in = s.getInputStream();

        System.out.println(in.read());
    }

    public static void startClient() throws Exception{
        Socket s=new Socket("localhost", port);
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        dos.write("message".getBytes());
//        OutputStream out=s.getOutputStream();
        dos.flush();
        dos.close();
//        out.flush();
//        out.close();
//        Scanner out=new Scanner();
    }

    public static void main(String[] args) throws Exception{
        Thread serverThread=new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    startServer();
                }catch (Exception e){
                    e.printStackTrace();
                    e.getMessage();
                }
            }
        });

        Thread clientThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    startClient();
                }catch (Exception e){
                    e.printStackTrace();
                    e.getMessage();
                }
            }
        });

        serverThread.start();
        clientThread.start();
    }
}