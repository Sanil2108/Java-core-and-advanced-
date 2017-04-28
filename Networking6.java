import java.io.*;
import java.net.*;

/**
 * Created by Admin on 23-04-2017.
 */
public class Networking6 {

    public static void main(String[] args) throws Exception{
        URLConnection urlConnection=(new URI("http://java.sun.com/cgi-bin/backwards").toURL()).openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        OutputStream outputStream=urlConnection.getOutputStream();

        outputStream.write("abcs".getBytes());

        InputStream inputStream=urlConnection.getInputStream();
        DataInputStream dataInputStream=new DataInputStream(inputStream);

        String s;
        while((s = dataInputStream.readLine()) != null){
            System.out.print(s);
        }
    }
}
