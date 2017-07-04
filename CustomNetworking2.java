import java.io.*;
import java.net.*;
import java.util.Scanner;

class CustomNetworking2{

    public static void main(String[] args){
        Thread t=new Thread(new QuoteServerRunnable());
        t.start();
    }

    public static class QuoteServerRunnable implements Runnable{

        @Override
        public void run(){
            BufferedReader in=null;
            try{
                in=new BufferedReader(new FileReader("quotes.txt"));
            }catch(Exception e){

            }
            while(true){
                try{
                    DatagramSocket socket=new DatagramSocket(4243);

                    byte[] buf=new byte[256];
                    DatagramPacket packet=new DatagramPacket(buf, buf.length);
                    
                    String quote;
                    quote=in.readLine();
                    if(quote==null){
                        System.out.println("End of file");
                        in.close();
                        in=new BufferedReader(new FileReader("quotes.txt"));
                        socket.close();
                        continue;

                    }

                    socket.receive(packet);

                    buf=quote.getBytes();

                    InetAddress address=packet.getAddress();
                    int port=packet.getPort();

                    packet=new DatagramPacket(buf, buf.length, address, port);
                    socket.send(packet);

                    System.out.println("Data sent to port number - "+port);

                    socket.close();

                }catch(IOException e){
                    e.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

}