import java.net.*;
class UDP2{
    public static void main(String[] args) throws Exception{
        DatagramSocket socket=new DatagramSocket(4242);

        byte[] request=new byte[100];
        DatagramPacket response = new DatagramPacket(request, request.length);
        socket.receive(response);
        System.out.println("Packet received\nContents - "+new String(response.getData(), 0, response.getLength(),
 "US-ASCII"));

        if(socket!=null){
            socket.close();
        }

    }
}