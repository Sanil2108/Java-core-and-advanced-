import java.net.*;
import java.io.*;

class Networking13{
    public static void main(String[] args){
        try{
            URL u1=new URL("https://serverfault.com/questions/2699/how-do-i-see-if-a-port-is-in-use-on-a-windows-machine");
            InputStream in=u1.openStream();
            int c;
            while((c = in.read()) != -1){
                System.out.print((char)c);
            }
        }catch (Exception e){

        }
    }
}