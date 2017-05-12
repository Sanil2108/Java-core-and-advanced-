import java.util.*;
import java.net.*;
import java.io.*;

public class Networking14{
    public static void main(String[] args){
        try{
            URL u=new URL("http://ultimateclassicrock.com/files/2015/01/Loser-630x420.jpg");
            URLConnection uc=u.openConnection();
            InputStream in=u.openStream();
            int c;
            while((c = in.read()) != -1){
                System.out.print((char)c);
            }
        }catch(Exception e){
            
        }
    }
}