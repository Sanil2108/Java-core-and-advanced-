import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Admin on 23-04-2017.
 */
public class Networking5 {
    public static void main(String[] args) throws Exception{
        URL url=new URI("http://codingbat.com/java").toURL();
        URLConnection conn = url.openConnection();
        InputStream in=conn.getInputStream();
        int c;
        while((c=in.read()) != -1){
            System.out.print((char)c);
        }
    }
}
