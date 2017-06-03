import java.net.*;
import java.io.*;

public class Networking17{

    static final int PORT=2628;
    static final String SERVER="dict.org";
    static final int TIMEOUT=15000;

    public static void main(String[] args) throws Exception{
        Socket socket=new Socket(SERVER, PORT);
        socket.setSoTimeout(TIMEOUT);
        OutputStream out=socket.getOutputStream();
        Writer writer=new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
        InputStream in=socket.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(in, "UTF-8"));

        for(String word : args){
            define(word, writer, reader);
        }

        writer.write("quit\r\n");
    }

    static void define(String word, Writer writer, BufferedReader reader)
 throws IOException, UnsupportedEncodingException {
        writer.write("DEFINE eng-lat " + word + "\r\n");
        writer.flush();
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            if (line.startsWith("250 ")) {
                return;
            } else if (line.startsWith("552 ")) {
                System.out.println("No definition found for " + word);
                return;
            }
            else if (line.matches("\\d\\d\\d .*")) continue;
            else if (line.trim().equals(".")) continue;
            else System.out.println(line);
        }
    }
}