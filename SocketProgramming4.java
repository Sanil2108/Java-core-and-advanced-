import java.*;
import java.io.*;
import java.net.*;

public class SocketProgramming4{

    private static int PORT=4242;
    private static InetAddress local;

    public static class Server{
        public static void main(String[] args) throws Exception{

            Thread t=new Thread(new Runnable(){

                @Override
                public void run(){
                    try{
                        ServerSocket server=new ServerSocket(PORT);
                        Socket s=server.accept();
                        DataInputStream in = new DataInputStream(s.getInputStream());

                        while(true){
                            System.out.print(in.readUTF());
                        }

                    }catch(SocketException se){

                        System.out.println("Connection has been closed by the client");

                    }catch(Exception e){
                        System.out.println(e);
                        e.printStackTrace();
                    }
                }

            });

            t.start();
        }
    }

    public static class Client{
        public static void main(String[] args) throws Exception{
            
            local=InetAddress.getByName("182.64.147.16");
            System.out.println(local);

            Thread t=new Thread(new Runnable(){

                @Override
                public void run(){
                    try{
                        Socket s=new Socket(local.getHostAddress(), PORT);
                        DataOutputStream out=new DataOutputStream(s.getOutputStream());

                        int s2;
                        while(true){
                            s2=System.in.read();
                            out.writeUTF(Character.toString((char)(s2)));
                        }
                    }catch(Exception e){
                        System.out.println(e);
                        e.printStackTrace();
                    }
                }

            });

            t.start();
        }
    }

}