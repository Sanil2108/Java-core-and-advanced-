import java.net.*;
import java.io.*;

class Networking16{
    public static void main(String[] args){
        try{
            URL u=new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/9GAG_new_logo.svg/2000px-9GAG_new_logo.svg.png");
            URLConnection con=u.openConnection();
            InputStream in=con.getInputStream();
            FileOutputStream out=new FileOutputStream("output.jpg");
            int c;
            while((c = in.read()) != -1){
                out.write((char)c);
            }
        }catch(Exception e){

        }
    }
}