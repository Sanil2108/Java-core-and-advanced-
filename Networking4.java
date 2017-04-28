import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class Networking4 {
    public static void main(String[] args) throws Exception {
        URL url;
        if(args.length>=1){
            url = (new URI(args[0]).toURL());
        }else {
            url = (new URI("https://projecteuler.net/").toURL());
        }
        InputStream inputStream=url.openStream();
        int c;
        while((c = inputStream.read())!=-1){
            System.out.print((char)c);
        }
    }
}
