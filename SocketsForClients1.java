import java.io.*;
import java.net.*;

public class SocketsForClients1{
    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("india.colorado.edu", 13);
        socket.setSoTimeout(15000);
        InputStream in=socket.getInputStream();

        int c;
        while((c = in.read()) != -1){
            System.out.print((char)c);
        }
    }
}