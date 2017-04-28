import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Admin on 27-04-2017.
 */
public class Networking9 {

    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("whois.internic.net", 43);
        InputStream in=socket.getInputStream();
        OutputStream out=socket.getOutputStream();

        System.out.println("Remote port - "+socket.getPort());
        System.out.println("Local port - "+socket.getLocalPort());

        out.write("google.com\n".getBytes());

        int c;
        while((c = in.read()) != -1){
            System.out.print((char)c);
        }
    }
}
