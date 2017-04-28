import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Admin on 27-04-2017.
 */
public class Networking12 {
    static int port = 1414;

    static class Server{
        public static void main(String[] args) throws Throwable{
            ServerSocket ss=new ServerSocket(port);
            System.out.println("Server started.\nListening for connections on port number "+port);


            while(true) {
                Socket s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                System.out.println(dis.readUTF());
            }
        }
    }

    static class Client{
        public static void main(String[] args) throws Exception{
            Socket s=new Socket("localhost", port);
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            String temp;
            Scanner in=new Scanner(System.in);
            while((temp = in.nextLine()) != "exit") {
                dos.writeUTF(temp);
            }
        }
    }
}
