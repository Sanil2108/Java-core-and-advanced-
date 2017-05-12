import java.net.*;
import java.io.*;
class SocketsForClients2{

    public static void main(String[] args){
        try{
            Socket s=new Socket("dict.org", 2628);
            s.setSoTimeout(15000);
            OutputStream out=s.getOutputStream();
            InputStream in=s.getInputStream();
            out.write("DEFINE eng-lat gold".getBytes());
            out.write("quit".getBytes());
            int c;
            while((c = in .read()) != -1){
                System.out.print((char)c);
            }
            s.close();
        }catch(Exception e){

        }
    }

}