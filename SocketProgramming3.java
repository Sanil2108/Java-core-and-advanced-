import java.io.*;
import java.*;
import java.net.*;

public class SocketProgramming3{

    public static void main(String[] args) throws IOException{
        final int PORT = 4242;

        Thread serverThread=new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    System.out.println("Server started");
                    ServerSocket server=new ServerSocket(PORT);
                    Socket client = server.accept();
                    DataInputStream in=new DataInputStream(client.getInputStream());
                    Thread serverStartedThread=new Thread(new Runnable(){
                        @Override
                        public void run(){
                            try{
                                while(true){
                                    System.out.println(in.readUTF());
                                }
                            }catch(IOException e){

                            }
                        }
                    });
                    serverStartedThread.start();
                }catch(IOException e){
                    
                }
            }
        });

        Thread clientThread=new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    System.out.println("Client started");
                    Socket server=new Socket("127.0.0.1", PORT);
                    DataOutputStream out=new DataOutputStream(server.getOutputStream());
                    out.writeUTF("Hello");
                    out.writeUTF("World");
                }catch(IOException e){
                    
                }
            }
        });

        serverThread.start();
        clientThread.start();
    }

}