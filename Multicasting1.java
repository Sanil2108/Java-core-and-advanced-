import java.net.*;
class Multicasting1{
    public static void main(String[] args){
        MulticastSocket socket=new MulticastSocket(2300);
        InetAddress group=InetAddress.getByName("224.2.2.2");
        socket.joinGroup(group);

        byte[] buffer=new byte[8192];
        DatagramPacket packet=new DatagramPacket(buffer, buffer.length);
        ms.receive(packet);

        ms.leaveGroup();
        ms.close();
        
    }
}