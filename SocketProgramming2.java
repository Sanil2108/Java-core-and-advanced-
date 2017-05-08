import java.net.*;
import java.io.*;
import java.lang.*;

class SocketProgramming2{
    public static void main(String[] args) throws Exception{
        if(args.length<2 || args.length>3){
            throw new RuntimeException("Dammit, thats not the correct number of arguments");
        }

        Socket socket=new Socket(args[0], (args.length==3)?Integer.parseInt(args[2]):7);

        // InputStream in=socket.getInputStream();
        // OutputStream out=socket.getOutputStream();

        // String toWrite="Hello, World";
        // out.write(toWrite.getBytes());

        // int totalBytesRcvd=0;
        // int bytesRcvd=0;

        // while(toWrite.getBytes().length > totalBytesRcvd){
        //     if ((bytesRcvd = in.read(toWrite.getBytes(), totalBytesRcvd,
        //         toWrite.getBytes().length - totalBytesRcvd)) == -1)
        //         throw new SocketException("Connection closed prematurely");
        //     totalBytesRcvd += bytesRcvd;
        // }
        // System.out.println("Received: " + new String(toWrite.getBytes())) ;
        // socket.close();
    }
}