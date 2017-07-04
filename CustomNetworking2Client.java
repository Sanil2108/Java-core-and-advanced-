import java.net.*;

class CustomNetworking2Client{

    public static void main(String[] args) throws Exception{

        InetAddress address=InetAddress.getLocalHost();
        int port=4243;
        byte[] buf=new byte[256];
        DatagramSocket socket=new DatagramSocket();
        DatagramPacket packet=new DatagramPacket(buf, buf.length, address, port);
        socket.send(packet);

        packet=new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String received=new String(packet.getData(), 0, packet.getLength());
        System.out.println(received);

    }

}