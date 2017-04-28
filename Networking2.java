import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Networking2 {
//    public static void main(String[] args) throws Throwable{
//        int c;
//        Socket socket=new Socket("google.com", 1210);
//
//        InputStream in=socket.getInputStream();
//        OutputStream out=socket.getOutputStream();
//
//        String command = "google.com";
//
////        while((c=in.read()) != -1){
////            System.out.print(c);
////        }
//        socket.close();
//    }
public static void main(String args[]) throws Exception {
    int c;
// Create a socket connected to internic.net, port 43.
    Socket s = new Socket("internic.net", 43);
// Obtain input and output streams.
    InputStream in = s.getInputStream();
    OutputStream out = s.getOutputStream();
// Construct a request string.
    String str = (args.length == 0 ? "osborne.com" : args[0]) + "\n";
// Convert to bytes.
    byte buf[] = str.getBytes();
// Send request.
    out.write(buf);
// Read and display response.
    while ((c = in.read()) != -1) {
        System.out.print((char) c);
    }
    s.close();
}
}
